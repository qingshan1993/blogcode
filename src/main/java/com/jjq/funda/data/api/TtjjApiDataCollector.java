package com.jjq.funda.data.api;

import com.google.common.io.Files;
import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.entity.FundComponent;
import com.jjq.funda.db.repo.FundRepo;
import com.jjq.funda.model.DataCollectParam;
import com.jjq.funda.model.GlobalConstant;
import com.jjq.funda.support.TtjjHttpClient;
import com.jjq.funda.util.JsonUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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
    public List<FunPerformance> collectFunPerformance(DataCollectParam collectParam) {
        return null;
    }
}
