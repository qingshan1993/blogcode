package com.jjq.funda.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/23
 * @desc 系统访问日志
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "access_log")
public class AccessLog {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * 日期
     */
    private String ip;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 访问的时间
     */
    private LocalDateTime accessTime;

    /**
     * 请求描述
     */
    private String accessDesc;

    /**
     * 请求地址
     */
    public String url;



    /**
     * 请求参数
     */
    public String reqParam;

    /**
     * 请求参数
     */
    private String respResult;
}
