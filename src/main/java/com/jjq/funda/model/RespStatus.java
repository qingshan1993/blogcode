package com.jjq.funda.model;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/2
 * @desc response统一相应结果
 */
public enum RespStatus {

    LOGIN_FAIL(10001, "login fail"),

    ARGUMENT_NOT_VALID(10002, "参数校验不通过"),
    ;


    private final int value;

    private final String reasonPhrase;


    RespStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
