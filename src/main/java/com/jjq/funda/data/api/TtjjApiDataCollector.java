package com.jjq.funda.data.api;

import com.google.common.io.Files;
import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.entity.FundComponent;
import com.jjq.funda.db.repo.FundRepo;
import com.jjq.funda.model.GlobalConstant;
import com.jjq.funda.model.param.DataCollectParam;
import com.jjq.funda.support.TtjjHttpClient;
import com.jjq.funda.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc
 */
@Slf4j
@Component
public class TtjjApiDataCollector implements ApiDataCollector {

    @Autowired
    private TtjjHttpClient ttjjHttpClient;
    public static String filepath = "C:\\Users\\Administrator\\Desktop\\新建文本文档.txt";

    @Autowired
    private FundRepo fundRepo;

    @Override
    public List<Fund> collectFund(DataCollectParam collectParam) {
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
        return null;
    }

    @Override
    public List<FundComponent> collectFundComponent(DataCollectParam collectParam) {
        return null;
    }

    @Override
    public List<FunPerformance> collectFunPerformance(DataCollectParam param) {
        String url = String.format(GlobalConstant.TtjjUrl.FUND_PERFORMANCE_URL, param.getFundCode(), param.getCurrent(), param.getPageSize());
        log.info("collectFunPerformance, url:{}", url);
        //String strResult = ttjjHttpClient.get(url, String.class);
        String strResult = "var apidata={ content:\"\n" +
                "净值日期\t单位净值\t累计净值\t日增长率\t申购状态\t赎回状态\t分红送配\n" +
                "2022-07-08\t2.7840\t3.0160\t0.80%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-07\t2.7620\t2.9940\t-2.06%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-06\t2.8200\t3.0520\t-1.30%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-05\t2.8570\t3.0890\t0.99%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-04\t2.8290\t3.0610\t4.78%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-01\t2.7000\t2.9320\t-1.10%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-30\t2.7300\t2.9620\t2.82%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-29\t2.6550\t2.8870\t-0.15%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-28\t2.6590\t2.8910\t-0.41%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-27\t2.6700\t2.9020\t1.17%\t限制大额申购\t开放赎回\t\n" +
                "\",records:1395,pages:140,curpage:1};";


        return null;
    }
}
