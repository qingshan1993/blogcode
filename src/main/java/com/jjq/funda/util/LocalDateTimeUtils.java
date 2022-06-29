package com.jjq.funda.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc LocalDateTime工具类
 */
public class LocalDateTimeUtils {

    /**
     * 将各种字符串转换为LocalDateTime
     * @param ch
     * @return
     */
    public static LocalDateTime parse(CharSequence ch) {
        return LocalDateTime.now();
    }


    /**
     * 将各种字符串转换为LocalDateTime
     * @param ch
     * @param di
     * @param pattern 时间格式的字符串,如
     * @return
     */
    public static LocalDateTime parse(CharSequence ch, DayInstant di, String pattern) {



        return LocalDateTime.now();
    }




}
