package com.jjq.funda.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.LongStream;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/23
 * @desc
 */
@Slf4j
public class LocalDateUtilsTest {


    /**
     * 计算日期区间的工作日天数
     * @param
     * @param
     * @return
     */
    @Test
    public void  betweenWeekdayTest() {
        LocalDate startInclude = LocalDateTimeUtils.parse("2022-07-01").toLocalDate();
        LocalDate endInclude =  LocalDateTimeUtils.parse("2022-07-31").toLocalDate();
        int i = LocalDateUtils.betweenWeekday(startInclude, endInclude);
        log.info("result:{}", i);
    }


}
