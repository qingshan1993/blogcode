package com.jjq.funda.queue;

import com.jjq.funda.model.param.DataCollectParam;
import com.jjq.funda.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/8
 * @desc 数据采集队列延时队列
 */
@Slf4j
@Component
public class DataCollectDelayQueue implements DataCollectQueue<DataCollectParam> {

    private DelayQueue<DataCollectParam> delayQueue = new DelayQueue<>();

    /**
     * 任务入队
     * @param param
     * @param timeout
     * @param unit
     */
    public void put(DataCollectParam param, long timeout, TimeUnit unit) {
        delayQueue.offer(param, timeout, unit);
        log.info("加入队列成功,param:{}", JsonUtils.toJsonString(param));
    }

    /**
     * 任务出队
     * @return
     */
    public DataCollectParam poll() {
        DataCollectParam poll = delayQueue.poll();
        if (poll != null) {
            log.info("队列消费成功,poll:{}", JsonUtils.toJsonString(poll));
        }
        return poll;
    }



}
