package com.jjq.funda.task;

import com.jjq.funda.db.entity.FundComponent;
import com.jjq.funda.db.repo.FundComponentRepo;
import com.jjq.funda.db.repo.FundPerformanceRepo;
import com.jjq.funda.db.repo.FundRepo;
import com.jjq.funda.db.repo.UserSubscribeFundRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/4
 * @desc 数据获取任务
 */
@Slf4j
@Service
public class DataCollectTask {


    @Autowired
    public FundRepo fundRepo;

    @Autowired
    public FundComponentRepo fundComponentRepo;

    @Autowired
    public FundPerformanceRepo fundPerformanceRepo;

    @Autowired
    public UserSubscribeFundRepo userSubscribeFundRepo;


    /**
     * 基金数据获取
     */
    public void collectFundData() {

    }


    /**
     * 基金业绩数据获取,历史数据全量获取
     */
    public void collectHistoryFunPerformanceData() {

    }

    /**
     * 基金业绩数据获取,增量数据获取
     */
    public void collectRecentFunPerformanceData() {
        //

    }

    /**
     * 基金持仓数据获取
     */
    public void collectFundComponentData() {

    }


}
