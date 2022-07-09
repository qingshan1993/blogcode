package com.jjq.funda.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/5
 * @desc 数据收集任务列表
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity(name = "data_collect_task_config")
public class DataCollectTaskConfig {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 配置项名
     */
    private String configName;

    /**
     * 配置项值
     */
    private String configValue;


}
