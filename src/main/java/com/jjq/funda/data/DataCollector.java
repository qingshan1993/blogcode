package com.jjq.funda.data;

import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.entity.FundComponent;
import com.jjq.funda.model.param.DataCollectParam;

import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc 基金数据收集器
 *
 */
public interface DataCollector {

    /**
     * 获取基金基本信息
     * @param collectParam
     * @return
     */
    void collectFund(DataCollectParam collectParam);


    /**
     * 获取基金持仓列表
     * @param collectParam
     * @return
     */
    void collectFundComponent(DataCollectParam collectParam);


    /**
     * 获取基金业绩信息
     * @param collectParam
     * @return
     */
    void collectFunPerformance(DataCollectParam collectParam);


}
