package com.jjq.funda.data.api;

import com.jjq.funda.FundaApplicationTests;
import com.jjq.funda.model.GlobalConstant;
import com.jjq.funda.model.param.DataCollectParam;

import com.jjq.funda.queue.DataCollectDelayQueue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/7
 * @desc
 */
@Slf4j
public class TtjjApiDataCollectorTest extends FundaApplicationTests {

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

    @Autowired
    private DataCollectDelayQueue dataCollectDelayQueue;

    @Test
    public void sendCollectFunComponentMsgTest() throws InterruptedException {
        DataCollectParam dataCollectParam = new DataCollectParam();
        dataCollectParam.setFundCode("003096");
        dataCollectParam.setCurrent(1);
        dataCollectParam.setPageSize(10);
        dataCollectParam.setMsgType(GlobalConstant.QueueMsgType.COLLECT_FUND_PERFORMANCE);
        dataCollectDelayQueue.put(dataCollectParam,20L, TimeUnit.SECONDS);
        log.info("发送消息:{}到延时队列,延时时间:{}s, 当前时间:{}",dataCollectParam, 20, dateTimeFormatter.format(LocalDateTime.now()));


        DataCollectParam dataCollectParam1 = new DataCollectParam();
        dataCollectParam1.setFundCode("000111");
        dataCollectParam1.setCurrent(1);
        dataCollectParam1.setPageSize(10);
        dataCollectParam1.setMsgType(GlobalConstant.QueueMsgType.COLLECT_FUND_PERFORMANCE);
        dataCollectDelayQueue.put(dataCollectParam1,10L, TimeUnit.SECONDS);
        log.info("发送消息:{}到延时队列,延时时间:{}s, 当前时间:{}",dataCollectParam1, 10, dateTimeFormatter.format(LocalDateTime.now()));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
