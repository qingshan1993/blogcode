package com.jjq.funda.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/5
 * @desc
 */
public class ListUtils {

    public static <T> List<T> emptyList() {
        return Collections.emptyList();
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        if (elements == null) {
            return newArrayList();
        }
        ArrayList<T> list = newArrayList();
        java.util.Collections.addAll(list, elements);
        return list;
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(ArrayList<T>... arrayLists) {

        return newArrayList();
    }

    @SafeVarargs
    public static <T> ArrayList<T> addAll(ArrayList<T> list, ArrayList<T>... arrayLists) {
        if (arrayLists == null) {
            return list;
        }

        return newArrayList();
    }



}
