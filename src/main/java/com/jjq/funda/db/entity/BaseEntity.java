package com.jjq.funda.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/2
 * @desc 基础的
 */
@Getter
@Setter
public class BaseEntity {

    /**
     * 数据创建时间
     */
    private Long creatorId;

    /**
     * 数据创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人ID
     */
    private Long updaterId;

    /**
     * 更新人ID
     */
    private LocalDateTime updateTime;
}
