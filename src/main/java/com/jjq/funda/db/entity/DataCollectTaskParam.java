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
@Entity(name = "data_collect_task_param")
public class DataCollectTaskParam {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * 任务名称
     */
    private String taskId;

    /**
     * 任务类型
     */
    private String paramName;

    /**
     * 任务状态
     */
    private String paramValue;


}
