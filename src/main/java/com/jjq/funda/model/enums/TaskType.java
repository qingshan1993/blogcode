package com.jjq.funda.model.enums;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/8
 * @desc 数据收集任务类型
 */
public enum TaskType {


    FUND_PERFORMANCE_DATA_COLLECT("fund_performance_data_collect", "基金业绩数据收集"),
    ;


    private final String value;

    private final String desc;


    TaskType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
