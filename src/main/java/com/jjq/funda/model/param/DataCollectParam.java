package com.jjq.funda.model.param;

import com.jjq.funda.model.QueueMsg;
import lombok.*;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

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
public class DataCollectParam extends QueueMsg implements Delayed {

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


    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
