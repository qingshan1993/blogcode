package com.jjq.funda.model.anno;

import java.lang.annotation.*;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc 队列监听器
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueueListener {

    /**
     * 消息类型
     * @return
     */
    String msgType() default "";

    /**
     * 具体参数类型
     * @return
     */
    Class<?> paramType();

    /**
     * 重试次数
     * @return
     */
    int retry() default 6;
}
