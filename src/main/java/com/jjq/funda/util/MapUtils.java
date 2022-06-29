package com.jjq.funda.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/5
 * @desc
 */
public class MapUtils {


    public static <K, V> HashMap<K, V> newHashMap(){
        return new HashMap<>();
    }


    public static Map<String, Object> fromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = newHashMap();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null) {
                    continue;
                }
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
