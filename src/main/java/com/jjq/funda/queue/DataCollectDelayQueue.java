package com.jjq.funda.queue;

import com.jjq.funda.model.param.DataCollectParam;
import com.jjq.funda.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
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
     */
    public void put(DataCollectParam param) {
        put(param, 1 + new Random().nextInt(25), TimeUnit.MINUTES);
    }

    @Override
    public void put(DataCollectParam param, long delayTime, TimeUnit timeUnit) {
        param.setPollTime(System.currentTimeMillis() + timeUnit.toMillis(delayTime));
        delayQueue.offer(param);
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
