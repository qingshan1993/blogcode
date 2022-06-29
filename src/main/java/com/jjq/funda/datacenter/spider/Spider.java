package com.jjq.funda.datacenter.spider;

import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/8
 * @desc
 */
public interface Spider {

    /**
     * 爬取业绩信息
     * @param spiderContext
     * @return
     */
    List<String> parseFundPerformance(SpiderContext spiderContext);


    /**
     * 爬取持仓信息
     * @param spiderContext
     * @return
     */
    List<String> parseFundComponent(SpiderContext spiderContext);


}
