package com.jjq.funda.model.param;

import lombok.*;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc 基金数据采集参数
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataCollectParam {


    /**
     * 基金编码
     */
    private String fundCode;

    /**
     * 分页请求每个条数
     */
    private Integer pageSize;

    /**
     * 当前第几页
     */
    private Integer current;
}
