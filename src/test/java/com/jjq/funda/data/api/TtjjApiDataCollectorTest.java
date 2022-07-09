package com.jjq.funda.data.api;

import com.jjq.funda.FundaApplicationTests;
import com.jjq.funda.model.param.DataCollectParam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/7
 * @desc
 */
public class TtjjApiDataCollectorTest extends FundaApplicationTests {

    @Autowired
    public TtjjApiDataCollector ttjjApiDataCollector;

    @Test
    public void collectFundTest() {
        ttjjApiDataCollector.collectFund(new DataCollectParam());
    }

    @Test
    public void collectFunPerformanceTest() {
        DataCollectParam dataCollectParam = new DataCollectParam();
        dataCollectParam.setFundCode("003096");
        dataCollectParam.setCurrent(1);
        dataCollectParam.setPageSize(10);
        ttjjApiDataCollector.collectFunPerformance(dataCollectParam);
    }
}
