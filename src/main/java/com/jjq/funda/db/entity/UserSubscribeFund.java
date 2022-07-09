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
 * @date 2022/7/9
 * @desc 用户基金订阅记录
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_subscribe_fund")
public class UserSubscribeFund {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 基金编码
     */
    private String fundCode;


    /**
     * 用户订阅时间
     */
    private LocalDateTime subscribeTime;

    /**
     * 取消订阅时间
     */
    private LocalDate cancelSubscribeTime;

    /**
     * 用户订阅状态
     */
    private String subscribeStatus;



}
