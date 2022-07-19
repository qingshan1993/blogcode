package com.jjq.funda.data.api;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.repo.FundPerformanceRepo;
import com.jjq.funda.db.repo.FundRepo;
import com.jjq.funda.model.GlobalConstant;
import com.jjq.funda.model.anno.QueueListener;
import com.jjq.funda.model.param.DataCollectParam;
import com.jjq.funda.queue.DataCollectDelayQueue;
import com.jjq.funda.support.TtjjHttpClient;
import com.jjq.funda.util.*;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc
 */
@Slf4j
@Component
public class TtjjApiDataCollector implements ApiDataCollector {

    public static String filepath = "C:\\Users\\Administrator\\Desktop\\新建文本文档.txt";
    public static DecimalFormat DF = new DecimalFormat("##.##%");
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private TtjjHttpClient ttjjHttpClient;

    @Autowired
    private FundRepo fundRepo;

    @Autowired
    private FundPerformanceRepo fundPerformanceRepo;

    @Autowired
    private DataCollectDelayQueue dataCollectDelayQueue;

    @Override
    public void collectFund(DataCollectParam collectParam) {
        //String s = ttjjHttpClient.get(GlobalConstant.TtjjUrl.FUND_URL, String.class);
        List<String> strings = null;
        try {
            strings = Files.readLines(new File(filepath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = strings.get(0);
        String substring = s.substring(9, s.length() - 2);
        String replaceAfter = substring.replace("],", "]@@@");
        String[] split = replaceAfter.split("@@@");
        List<Fund> fundList = new ArrayList<>(20000);
        for (String str :split) {
            List<String> fundStrList = JsonUtils.parseList(str, String.class);
            Fund fund = Fund.builder()
                    .fundCode(fundStrList.get(0))
                    .fundName(fundStrList.get(2))
                    .simplePinyin(fundStrList.get(1))
                    .pinyin(fundStrList.get(4))
                    .fundType(fundStrList.get(3))
                    .build();
            fund.setCreatorId(0L);
            fund.setUpdaterId(0L);
            fund.setManager("");
            fund.setStatus("");
            fundList.add(fund);
        }
        List<Fund> saveAllResult = fundRepo.saveAll(fundList);
        log.info("批量保存基金数据，saveAllResult：{}， fundListSize：{}", saveAllResult, fundList.size());
    }


    @Override
    public void collectFunPerformance(DataCollectParam param) {
        collectFunPerformance(param, false);
    }

    @QueueListener(msgType = GlobalConstant.QueueMsgType.COLLECT_FUND_PERFORMANCE)
    public void collectFundComponentFromQueueTask(DataCollectParam collectParam) {
        log.info("开始执行基金数据收集,collectParam:{}, 当前时间:{}", JsonUtils.toJsonString(collectParam), dateTimeFormatter.format(LocalDateTime.now()));
        collectFunPerformance(collectParam, true);
    }

    public void collectFunPerformance(DataCollectParam param, boolean fromQueue) {
        String url = String.format(GlobalConstant.TtjjUrl.FUND_PERFORMANCE_URL, param.getFundCode(), param.getCurrent(), param.getPageSize());
        log.info("collectFunPerformance, url:{}", url);
        String strResult = ttjjHttpClient.get(url, String.class);
        String jsStr = strResult.replace("\"\n", "\"")
                .replace("\t","@").replace("\n","@@").replace("@@@","@@");
        Map<String, Object> dataMap = JsUtils.parseJjObject(jsStr, "apidata");
        String content = (String) dataMap.get("content");
        //从响应信息中解析基金业绩数据, 已去掉表头
        List<List<String>> contentList = parseContent(content);
        List<FunPerformance> funPerformanceList = new ArrayList<>(contentList.size());
        for (int i = 0; i < contentList.size(); i++) {
            List<String> item = contentList.get(i);
            FunPerformance funPerformance = FunPerformance.builder()
                    .fundCode(param.getFundCode())
                    .fundDate(LocalDateTimeUtils.parse(item.get(0)).toLocalDate())
                    .unitValue(new BigDecimal(item.get(1)))
                    .totalUnitValue(new BigDecimal(item.get(2)))
                    .risePercent(BigDecimalUtils.parseWithPercentSymbol(item.get(3)))
                    .purchaseStatus(item.get(4))
                    .redeemStatus(item.get(5))
                    .estimateUnitValue(new BigDecimal(item.get(1)))
                    .estimateTotalUnitValue(new BigDecimal(item.get(2)))
                    .estimateRisePercent(BigDecimalUtils.parseWithPercentSymbol(item.get(3)))
                    .estimateTime(LocalDateTimeUtils.parse(item.get(0)))
                    .build();
            funPerformanceList.add(funPerformance);
        }
        List<FunPerformance> saveAll = fundPerformanceRepo.saveAll(funPerformanceList);
        log.info("批量保存基金业绩数据成功, fundCode:{}, saveAllSize:{}", param.getFundCode(), saveAll.size());
        if (!fromQueue && param.getCurrent() == 1 && saveAll.size() > 0) {
            Integer pages = (Integer) dataMap.get("pages");
            Random random = new Random();
            for (int i = 2; i <= pages; i++) {
                DataCollectParam dataCollectParam = new DataCollectParam();
                dataCollectParam.setMsgType(GlobalConstant.QueueMsgType.COLLECT_FUND_PERFORMANCE);
                dataCollectParam.setFundCode(param.getFundCode());
                dataCollectParam.setPageSize(param.getPageSize());
                dataCollectParam.setCurrent(i);
                dataCollectDelayQueue.put(dataCollectParam, 1 + random.nextInt(25), TimeUnit.MINUTES);
            }
        }
    }

    /**
     * 从响应信息中解析基金业绩数据, 已去掉表头
     * @param content
     * @return
     */
    private List<List<String>> parseContent(String content) {
        List<List<String>> result = new ArrayList<>(20);
        if (JsoupUtils.isValidHtmlFragment(content)) {
            result = JsoupUtils.parseTable(content);
        } else {
            String[] funPerformanceArr = content.split("@@");
            for (int i = 1; i <funPerformanceArr.length; i++) {
                String[] split = funPerformanceArr[i].split("@");
                result.add(Lists.newArrayList(split));
            }
        }
        return result;
    }

    @Override
    public void collectFundComponent(DataCollectParam collectParam) {

    }

    @QueueListener(msgType = GlobalConstant.QueueMsgType.TEST)
    public void testConsumeQueueMsg(DataCollectParam collectParam) {
        log.info("开始执行基金数据收集,collectParam:{}, 当前时间:{}", JsonUtils.toJsonString(collectParam), dateTimeFormatter.format(LocalDateTime.now()));
    }
}
