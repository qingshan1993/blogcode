package com.jjq.funda.util;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/23
 * @desc
 */
@Slf4j
public class LocalDateUtils {


    /**
     * 计算日期区间的工作日天数
     * @param startInclude
     * @param endInclude
     * @return
     */
    public static int betweenWeekday(LocalDate startInclude, LocalDate endInclude) {
        if (startInclude == null || endInclude == null) {
            throw new IllegalArgumentException("开始日期和结束日期都不允许为空");
        }
        if (endInclude.isBefore(startInclude)) {
            throw new IllegalArgumentException("endInclude can not isBefore startInclude.");
        }

        long diffDays = endInclude.toEpochDay() - startInclude.toEpochDay();
        return (int) LongStream.rangeClosed(0, diffDays).filter(x -> {
            DayOfWeek dayOfWeek = startInclude.plusDays(x).getDayOfWeek();
            return !dayOfWeek.equals(DayOfWeek.SATURDAY) && !dayOfWeek.equals(DayOfWeek.SUNDAY);
        }).count();
    }

}
