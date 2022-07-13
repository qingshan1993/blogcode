package com.jjq.funda.queue;

import java.util.concurrent.TimeUnit;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/8
 * @desc 数据采集队列
 */
public interface DataCollectQueue<T> {

    /**
     * 发送普通任务入队
     * @param param
     */
    void put(T param) ;

    /**
     * 发送普通任务入队
     * @param param
     */
    void put(T param, long delayTime, TimeUnit timeUnit) ;

    /**
     * 任务出队
     * @return
     */
    T poll();
}
