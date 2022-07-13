package com.jjq.funda.model;

import lombok.*;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/10
 * @desc 队列消息包装类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueueMsg {

    /**
     * 消息类型
     */
    public String msgType;

    /**
     * 已重试次数
     */
    public int retried;

    /**
     * 消息消费时间
     */
    public long pollTime;
}
