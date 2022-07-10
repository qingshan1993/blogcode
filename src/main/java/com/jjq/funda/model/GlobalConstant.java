package com.jjq.funda.model;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
public interface GlobalConstant {


    interface TtjjUrl {
        /**
         * 全部的基金列表
         */
        String FUND_URL = "http://fund.eastmoney.com/js/fundcode_search.js";

        /**
         *code 基金编码
         *page 当前第几页 从1开始
         *per 每页条数,最大50
         */
        String FUND_PERFORMANCE_URL = "http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=%s&page=%s&per=%s";

        String FUND_COMPONENT_URL = "http://fund.eastmoney.com/js/fundcode_search.js";

    }

    /**
     * 队列消息
     */
    interface QueueMsgType {

        String COLLECT_FUND_PERFORMANCE = "COLLECT_FUND_PERFORMANCE";

    }


}
