package com.jjq.funda.queue;

import org.springframework.stereotype.Component;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc 队列监听处理
 */
@Component
public class QueueListenerProcessor {

    public void init() {
        //搜索整个项目中,找到带有@QueueListener注解的方法

        //缓存起来
    }

    public void listen() {
        //开启守护线程

        //for循环监听队列,如果队列消费成功,调用指定的监听方法

    }


}
