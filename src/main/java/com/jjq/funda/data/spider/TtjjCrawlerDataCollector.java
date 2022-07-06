package com.jjq.funda.data.spider;

import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.entity.FundComponent;
import com.jjq.funda.model.DataCollectParam;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc
 */
public class TtjjCrawlerDataCollector implements CrawlerDataCollector {


    @Override
    public List<Fund> collectFund(DataCollectParam collectParam) {
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
