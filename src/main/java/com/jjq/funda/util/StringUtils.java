package com.jjq.funda.util;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/5
 * @desc
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        return !isNotBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.length() > 0 && containsText(str);
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for(int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean equals(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }
}
