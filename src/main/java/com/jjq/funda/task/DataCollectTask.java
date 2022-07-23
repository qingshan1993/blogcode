package com.jjq.funda.task;

import com.jjq.funda.db.repo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    @Autowired
    public ChinaHolidayRepo chinaHolidayRepo;


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
        //查询用户已订阅的基金编码
        List<String> fundCodeList = userSubscribeFundRepo.listUserSubscribedFundCode();
        if (CollectionUtils.isEmpty(fundCodeList)) {
            log.info("用户已订阅的基金列表为空,无需收集基金业绩数据,直接返回.");
            return;
        }
        for (String fundCode : fundCodeList) {
            LocalDate maxFundDate = fundPerformanceRepo.findMaxFundDateByFundCode(fundCode);



        }
        //

    }

    /**
     * 基金持仓数据获取
     */
    public void collectFundComponentData() {

    }


}
