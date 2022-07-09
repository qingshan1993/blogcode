package com.jjq.funda.exception;

import org.springframework.lang.Nullable;

/**
 * @author jiangjunqing
 * @date 2021/11/16
 * @description: 整个项目的异常
 * @version:
 */
public class FundaException extends RuntimeException {

    /**
     * Create a new BeanCopyException with the specified message.
     * @param msg the detail message
     */
    public FundaException(String msg) {
        super(msg);
    }

    /**
     * Create a new BeanCopyException with the specified message  and root cause.
     * @param msg the detail message
     * @param cause the root cause
     */
    public FundaException(String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }
}
