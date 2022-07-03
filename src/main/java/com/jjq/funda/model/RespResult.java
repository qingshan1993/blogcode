package com.jjq.funda.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author  qingshan1993
 * @date  2022/7/2
 * @version 1.0
 * @desc
 */
public class RespResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    public static <T> RespResult<T> success(int code, String message,T data) {
        return new RespResult<T>(code, message, data);
    }

    public static <T> RespResult<T> success(T data) {
        return new RespResult<T>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> RespResult<T> success(RespStatus respStatus,T data) {
        return new RespResult<T>(respStatus.getValue(), respStatus.getReasonPhrase(), data);
    }

    public static RespResult<Void> success(RespStatus respStatus) {
        return new RespResult(respStatus.getValue(), respStatus.getReasonPhrase(), null);
    }

    public static RespResult<String> argumentNotValid(String data) {
        return success(RespStatus.ARGUMENT_NOT_VALID, data);
    }

    public static RespResult<Void> loginFail() {
        return success(RespStatus.ARGUMENT_NOT_VALID);
    }



    public RespResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
