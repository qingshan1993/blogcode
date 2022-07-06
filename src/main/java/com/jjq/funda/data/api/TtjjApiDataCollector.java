package com.jjq.funda.data.api;

import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.entity.FundComponent;
import com.jjq.funda.model.DataCollectParam;

import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc
 */
public class TtjjApiDataCollector implements ApiDataCollector {

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
