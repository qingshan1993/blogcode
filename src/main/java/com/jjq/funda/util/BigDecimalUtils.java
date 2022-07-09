package com.jjq.funda.util;

import java.math.BigDecimal;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc BigDecimal工具类
 */
public class BigDecimalUtils {


    /**
     * 解析带百分比符号的字符串
     * @param str
     * @return
     */
    public static BigDecimal parseWithPercentSymbol(String str) {
        if (StringUtils.isNotBlank(str) && str.trim().endsWith("%")) {
            return new BigDecimal(str.trim().replace("%","")).divide(new BigDecimal(100));
        }
        return null;
    }
}
