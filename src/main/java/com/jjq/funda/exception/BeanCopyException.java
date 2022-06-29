package com.jjq.funda.exception;

import org.springframework.lang.Nullable;

/**
 * @author jiangjunqing
 * @date 2021/11/16
 * @description: bean复制异常
 * @version:
 */
public class BeanCopyException extends RuntimeException {

    /**
     * Create a new BeanCopyException with the specified message.
     * @param msg the detail message
     */
    public BeanCopyException(String msg) {
        super(msg);
    }

    /**
     * Create a new BeanCopyException with the specified message  and root cause.
     * @param msg the detail message
     * @param cause the root cause
     */
    public BeanCopyException(String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }
}
