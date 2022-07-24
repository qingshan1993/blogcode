package com.jjq.funda.task;

import com.jjq.funda.data.api.TtjjApiDataCollector;
import com.jjq.funda.db.repo.*;
import com.jjq.funda.model.GlobalConstant;
import com.jjq.funda.model.param.DataCollectParam;
import com.jjq.funda.queue.DataCollectDelayQueue;
import com.jjq.funda.util.LocalDateUtils;
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

    @Autowired
    public DataCollectDelayQueue dataCollectDelayQueue;

    @Autowired
    public TtjjApiDataCollector ttjjApiDataCollector;


    /**
     * 基金数据获取
     */
    public void collectFundData() {

    }


    /**
     * 基金业绩数据获取,历史数据全量获取
     */
    public void collectHistoryFunPerformanceData() {
        //查询用户已订阅的基金编码
        List<String> fundCodeList = userSubscribeFundRepo.listUserSubscribedFundCode();
        if (CollectionUtils.isEmpty(fundCodeList)) {
            log.info("用户已订阅的基金列表为空,无需收集基金业绩数据,直接返回.");
            return;
        }
        for (String fundCode : fundCodeList) {
            LocalDate maxFundDate = fundPerformanceRepo.findMaxFundDateByFundCode(fundCode);
            if (maxFundDate != null) {
                continue;
            }
            DataCollectParam dataCollectParam = new DataCollectParam();
            dataCollectParam.setMsgType(GlobalConstant.QueueMsgType.COLLECT_FUND_PERFORMANCE);
            dataCollectParam.setPageSize(GlobalConstant.REQUEST_PAGE_SIZE_20);
            dataCollectParam.setCurrent(1);
            dataCollectParam.setFundCode(fundCode);
            ttjjApiDataCollector.collectFunPerformance(dataCollectParam);
        }

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
            if (maxFundDate == null || !maxFundDate.isBefore(LocalDate.now())) {
                continue;
            }
            int days = LocalDateUtils.betweenWeekday(maxFundDate, LocalDate.now());
            int pages = 1 + (days / GlobalConstant.REQUEST_PAGE_SIZE_20);
            for (int i = 1; i<= pages; i++) {
                DataCollectParam dataCollectParam = new DataCollectParam();
                dataCollectParam.setMsgType(GlobalConstant.QueueMsgType.COLLECT_FUND_PERFORMANCE);
                dataCollectParam.setPageSize(GlobalConstant.REQUEST_PAGE_SIZE_20);
                dataCollectParam.setCurrent(i);
                dataCollectParam.setFundCode(fundCode);
                dataCollectDelayQueue.put(dataCollectParam);
            }
        }
    }

    /**
     * 基金持仓数据获取
     */
    public void collectFundComponentData() {

    }


}
