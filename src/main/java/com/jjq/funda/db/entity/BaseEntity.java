package com.jjq.funda.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/2
 * @desc 基础的
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    /**
     * 数据创建时间
     */
    protected Long creatorId;

    /**
     * 数据创建时间
     */
    protected LocalDateTime createTime;

    /**
     * 更新人ID
     */
    protected Long updaterId;

    /**
     * 更新人ID
     */
    protected LocalDateTime updateTime;
}
