package com.jjq.funda.model.param;

import com.jjq.funda.model.QueueMsg;
import com.jjq.funda.util.JsonUtils;
import lombok.*;

import javax.swing.*;
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
        return  unit.convert(this.getPollTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) {
            return 0;
        }
        if (other instanceof QueueMsg) {
            QueueMsg x = (QueueMsg)other;
            long diff = this.getPollTime() - x.getPollTime();
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}
