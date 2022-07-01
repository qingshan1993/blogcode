package com.jjq.funda.conf;

import com.jjq.funda.model.RespResult;
import com.jjq.funda.model.RespStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/2
 * @desc 统一异常处理器
 * https://blog.csdn.net/fly1north/article/details/124666707
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RespResult handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder stringBuilder = new StringBuilder(RespStatus.ARGUMENT_NOT_VALID.getReasonPhrase());
        stringBuilder.append(":");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";");
        }
        return RespResult.argumentNotValid(stringBuilder.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RespResult handleConstraintViolationException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        return RespResult.argumentNotValid(exception.getMessage());
    }
}
