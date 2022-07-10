package com.jjq.funda.queue;

import com.jjq.funda.model.param.DataCollectParam;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/8
 * @desc 数据采集队列
 */
public interface DataCollectQueue<T extends Delayed> {

    /**
     * 任务入队
     * @param param
     * @param timeout
     * @param unit
     */
    void put(T param, long timeout, TimeUnit unit) ;

    /**
     * 任务出队
     * @return
     */
    T poll();
}
