package com.jjq.funda.model;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
public interface GlobalConstant {

    interface TtjjUrl {
        String FUND_URL = "http://fund.eastmoney.com/js/fundcode_search.js";

        String FUND_PERFORMANCE_URL = "http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=%s&page=1&per=50";

        String FUND_COMPONENT_URL = "http://fund.eastmoney.com/js/fundcode_search.js";

    }


}
