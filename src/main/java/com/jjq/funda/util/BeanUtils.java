package com.jjq.funda.util;

import com.jjq.funda.exception.BeanCopyException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/5
 * @desc
 */
public class BeanUtils {

    public static <T> T toBean(Object object, Class<T> tClass) {
        String jsonString = JsonUtils.toJsonString(object);
        return JsonUtils.parseObject(jsonString, tClass);
    }

    public static <T> T copyBean(Object object, Class<T> tClass) throws BeanCopyException {
        try {
            T t = tClass.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(object, t, tClass);
            return t;
        } catch (Exception e) {
            throw new BeanCopyException("copy object fail", e);
        }
    }

    public static <S,T> List<T> copyList(List<S> sourceList, Class<T> tClass) throws BeanCopyException {
        return JsonUtils.parseList(JsonUtils.toJsonString(sourceList), tClass);
    }




}
