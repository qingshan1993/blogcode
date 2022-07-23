package com.jjq.funda.model;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
public interface GlobalConstant {


    /**
     * 分页请求的每页的size
     */
    int REQUEST_PAGE_SIZE_20 = 20;


    interface TtjjUrl {
        /**
         * 全部的基金列表
         */
        String FUND_URL = "http://fund.eastmoney.com/js/fundcode_search.js";

        /**
         *code 基金编码
         *page 当前第几页 从1开始
         *per 每页条数,最大20
         * 返回例子:
         *  String strResult = "var apidata={ content:\"\n" +
         *                 "净值日期\t单位净值\t累计净值\t日增长率\t申购状态\t赎回状态\t分红送配\n" +
         *                 "2022-07-08\t2.7840\t3.0160\t0.80%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-07-07\t2.7620\t2.9940\t-2.06%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-07-06\t2.8200\t3.0520\t-1.30%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-07-05\t2.8570\t3.0890\t0.99%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-07-04\t2.8290\t3.0610\t4.78%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-07-01\t2.7000\t2.9320\t-1.10%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-06-30\t2.7300\t2.9620\t2.82%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-06-29\t2.6550\t2.8870\t-0.15%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-06-28\t2.6590\t2.8910\t-0.41%\t限制大额申购\t开放赎回\t\n" +
         *                 "2022-06-27\t2.6700\t2.9020\t1.17%\t限制大额申购\t开放赎回\t\n" +
         *                 "\",records:1395,pages:140,curpage:1};";
         */
        String FUND_PERFORMANCE_URL = "https://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=%s&page=%s&per=%s";

        String FUND_COMPONENT_URL = "http://fund.eastmoney.com/js/fundcode_search.js";

    }

    /**
     * 队列消息
     */
    interface QueueMsgType {

        String TEST = "test_msg_type";

        /**
         * 基金业绩数据
         */
        String COLLECT_FUND_PERFORMANCE = "collect_fund_performance";

        /**
         * 节假日信息数据
         */
        String CHINA_HOLIDAY_DATA = "china_holiday_data";


    }


}
