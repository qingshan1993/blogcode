package com.jjq.funda.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jjq
 * @version 1.0
 * @date 2022/1/17
 * @desc  a wrapper of DateTimeFormatter
 */
public class DateTimeFormatterWrapper {

    public static char[] REMOVE_CHARS_DEFAULT = new char[]{'年','月','日','时','分','秒','-','/',':'};

    /**
     *
     * @param text
     * @return
     */
    public static DateTimeFormatter toPure(String text) {
        String charSequence = removeChars(text, REMOVE_CHARS_DEFAULT);
        return DateTimeFormatter.ofPattern(charSequence);
    }

    public static DateTimeFormatter toPure(String text, char... extendChars) {
        String charSequence = removeChars(text,  extendChars(extendChars));
        return DateTimeFormatter.ofPattern(charSequence);
    }

    public static char[] extendChars(char... targets) {
        if (targets.length > 0) {
            char[] newChars = new char[REMOVE_CHARS_DEFAULT.length+targets.length];
            System.arraycopy(REMOVE_CHARS_DEFAULT, 0, newChars, 0, REMOVE_CHARS_DEFAULT.length);
            for (int i = 0; i < targets.length; i++) {
                newChars[REMOVE_CHARS_DEFAULT.length + i] = targets[i];
            }
            return newChars;
        }
        return REMOVE_CHARS_DEFAULT;
    }


    public static String removeChars(CharSequence sequence, char... targets) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<sequence.length(); i++) {
            sb.append(sequence.charAt(i));
            for (char target : targets) {
                if (sequence.charAt(i) == target) {
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public final static DateTimeFormatter STANDARD = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static void main(String[] args) {
        String s = "20220119100846";
        LocalDateTime parse = LocalDateTime.parse(s, STANDARD);
        System.out.println(parse.toString());
    }





}
