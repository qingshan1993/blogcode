package com.jjq.funda.util;

import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangjunqing
 * @date 2022/7/29
 * @description: LocalDateTime工具类
 * @version:
 */
@Slf4j
public class LocalDateTimeUtils {

    private static List<String> DATE_PATTERN;

    private static List<String> TIME_PATTERN;

    public final static char[] REPLACE_SPLIT_CHARS = new char[]{'年','月','日','时','分','秒','/',':','T',' ',' '};

    static {
        DATE_PATTERN = new ArrayList<>();
        DATE_PATTERN.add("yyyy-MM-dd");
        DATE_PATTERN.add("yyyyMMdd");
        DATE_PATTERN.add("yyyy-M-d");

        TIME_PATTERN = new ArrayList<>();
        TIME_PATTERN.add("-HH-mm-ss");
        TIME_PATTERN.add("-H-mm");
        TIME_PATTERN.add("-HH-mm");
        TIME_PATTERN.add("-HHmmss");
        TIME_PATTERN.add("-H-mm-ss");
    }

    /**
     * 将各种字符串转换为LocalDateTime(重载方法)
     * @param text
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String text) {
        return parse(text, DayInstant.DAY_OF_START, null, null, null);
    }

    /**
     * 将各种字符串转换为LocalDateTime(重载方法)
     * @param text
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String text, DayInstant di) {
        return parse(text, di, null, null, null);
    }

    /**
     * 将各种字符串转换为LocalDateTime(重载方法)
     * @param text
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String text,char[] removeChars) {
        return parse(text, DayInstant.DAY_OF_START, null, null, removeChars);
    }

    /**
     * 将各种字符串转换为LocalDateTime(重载方法)
     * @param text
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String text, List<String> datePattern, List<String> timePattern) {
        return parse(text, DayInstant.DAY_OF_START, datePattern, timePattern, null);
    }

    /**
     * 将各种字符串转换为LocalDateTime
     * @param sourceText
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String sourceText, DayInstant di, List<String> datePattern,
                                      List<String> timePattern, char[] removeChars) {
        LocalDateTime result = null;
        //对sourceText进行处理,去除首尾空格和多余的字符
        String text = toStandard(sourceText.trim(), removeChars);
        //拼接时间格式字符串
        List<String> patternList = contactPattern(datePattern, timePattern);
        for (String pattern : patternList) {
            result = parse(text, di, pattern);
            if (result != null) {
                break;
            }
        }
        if (result == null) {
            log.error("字符串转换为时间失败, sourceText:{}", sourceText);
            throw new DateTimeParseException("时间格式转换异常,sourceText:" + sourceText, sourceText, -1);
        }
        return result;
    }

    public static boolean isLocalDate(String sourceText) {
        return isLocalDate(sourceText, null,null);
    }

    public static boolean isLocalDate(String sourceText, List<String> datePattern, char[] replaceChars) {
        if (StringUtils.isBlank(sourceText)) {
            return false;
        }
        if (CollectionUtils.isNotEmpty(datePattern)) {
            DATE_PATTERN.addAll(datePattern);
        }
        String text = toStandard(sourceText.trim(), replaceChars);
        LocalDate localDate = null;
        for (String pattern : DATE_PATTERN) {
            localDate = parseLocalDate(text, pattern);
            if (localDate != null) {
                break;
            }
        }
        return localDate != null;
    }

    public static boolean isLocalDateTime(String sourceText) {
        return isLocalDateTime(sourceText, null, null, null);
    }

    public static boolean isLocalDateTime(String sourceText, List<String> datePattern,
                                   List<String> timePattern, char[] removeChars) {
        if (StringUtils.isBlank(sourceText)) {
            return false;
        }
        String text = toStandard(sourceText.trim(), removeChars);
        List<String> patternList = contactLocalDateTimePattern(datePattern, timePattern);
        LocalDateTime localDateTime = null;
        for (String pattern : patternList) {
            localDateTime = parseLocalDateTime(text, pattern);
            if (localDateTime != null) {
                break;
            }
        }
        return localDateTime != null;
    }

    /**
     * 字符串转LocalDate
     * @param text
     * @param pattern
     * @return
     */
    private static LocalDate parseLocalDate(String text, String pattern) {
        try {
            if (StringUtils.isNotEmpty(text)) {
                return LocalDate.parse(text, DateTimeFormatter.ofPattern(pattern));
            }
        } catch (DateTimeParseException exception) {
            //do nothing
        }
        return null;
    }

    /**
     * 字符串转LocalDate
     * @param text
     * @param pattern
     * @return
     */
    private static LocalDateTime parseLocalDateTime(String text, String pattern) {
        try {
            if (StringUtils.isNotEmpty(text)) {
                return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(pattern));
            }
        } catch (DateTimeParseException exception) {
            //do nothing
        }
        return null;
    }


    /**
     * 将字符串转换为LocalDateTime
     * @param text
     * @param di
     * @param pattern 时间格式的字符串,如
     * @return
     */
    private static LocalDateTime parse(String text, DayInstant di, String pattern) {
        LocalDateTime localDateTime = parseLocalDateTime(text, pattern);
        if (localDateTime != null) {
            return localDateTime;
        }
        LocalDate localDate = parseLocalDate(text, pattern);
        if (localDate != null) {
            return atDateTime(localDate, di);
        }
        return null;
    }


    private static LocalDateTime atDateTime(LocalDate localDate, DayInstant di) {
        if (DayInstant.DAY_OF_CURRENT.equals(di)) {
            return localDate.atTime(LocalTime.now());
        } else if (DayInstant.DAY_OF_START.equals(di)) {
            return localDate.atTime(LocalTime.MIN);
        } else if (DayInstant.DAY_OF_END.equals(di)) {
            return localDate.atTime(LocalTime.MAX);
        } else {
            return null;
        }
    }


    /**
     * 拼接更各种不同的pattern
     * @return
     */
    private static List<String> contactPattern(List<String> datePattern, List<String> timePattern) {
        if (CollectionUtils.isNotEmpty(datePattern)) {
            DATE_PATTERN.addAll(datePattern);
        }
        if (CollectionUtils.isNotEmpty(timePattern)) {
            TIME_PATTERN.addAll(timePattern);
        }
        List<String> patternList = new ArrayList<>(16);
        for (int i = 0; i < DATE_PATTERN.size(); i++) {
            patternList.add(DATE_PATTERN.get(i));
            for (int j = 0; j <TIME_PATTERN.size(); j++) {
                patternList.add(DATE_PATTERN.get(i) + TIME_PATTERN.get(j));
            }
        }
        return patternList;
    }

    /**
     * 拼接更各种不同的pattern
     * @return
     */
    private static List<String> contactLocalDateTimePattern(List<String> datePattern, List<String> timePattern) {
        if (CollectionUtils.isNotEmpty(datePattern)) {
            DATE_PATTERN.addAll(datePattern);
        }
        if (CollectionUtils.isNotEmpty(timePattern)) {
            TIME_PATTERN.addAll(timePattern);
        }
        List<String> patternList = new ArrayList<>(16);
        for (int i = 0; i < DATE_PATTERN.size(); i++) {
            for (int j = 0; j <TIME_PATTERN.size(); j++) {
                patternList.add(DATE_PATTERN.get(i) + TIME_PATTERN.get(j));
            }
        }
        return patternList;
    }


    /**
     * 转换为标准的时间格式
     * @param text
     * @param extendChars
     * @return
     */
    public static String toStandard(String text, char... extendChars) {
        return replaceChars(text,  extendChars(extendChars));
    }

    /**
     * 扩展replace char[]
     * @param targets
     * @return
     */
    private static char[] extendChars(char... targets) {
        if (targets != null) {
            char[] newChars = new char[REPLACE_SPLIT_CHARS.length+targets.length];
            System.arraycopy(REPLACE_SPLIT_CHARS, 0, newChars, 0, REPLACE_SPLIT_CHARS.length);
            for (int i = 0; i < targets.length; i++) {
                newChars[REPLACE_SPLIT_CHARS.length + i] = targets[i];
            }
            return newChars;
        }
        return REPLACE_SPLIT_CHARS;
    }


    private static String replaceChars(CharSequence sequence, char... targets) {
        if (StringUtils.isBlank(sequence)) {
            return sequence.toString();
        }
        //替换字符
        String temStr = sequence.toString().trim();
        for (char target : targets) {
            temStr = temStr.replace(target, '-');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<temStr.length(); i++) {
            if (i > 0 && temStr.charAt(i) == '-' && temStr.charAt(i-1) == '-') {
                //处理中间多个空格的情况
                continue;
            }
            if (i == temStr.length()-1 && temStr.charAt(i) == '-') {
               continue;
            }
            sb.append(temStr.charAt(i));
        }

        return sb.toString();
    }










}
