package com.jjq.funda.model.anno;

import java.lang.annotation.*;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/25
 * @desc 访问日志注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLog {

    /**
     * 自定义的日志的描述信息
     * @return
     */
    String value() default "";
}
