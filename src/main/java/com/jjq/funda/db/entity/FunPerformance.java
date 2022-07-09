package com.jjq.funda.db.entity;

import com.jjq.funda.util.JsonUtils;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/5
 * @desc 基金业绩
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fund_performance")
public class FunPerformance {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * 基金编码
     */
    private String fundCode;

    /**
     * 日期
     */
    private LocalDate fundDate;

    /**
     * 单位净值
     */
    private BigDecimal unitValue;

    /**
     * 累计净值
     */
    private BigDecimal totalUnitValue;

    /**
     * 增长幅度
     */
    private BigDecimal risePercent;

    /**
     * 申购状态
     */
    private String purchaseStatus;

    /**
     * 赎回状态
     */
    private String redeemStatus;

    /**
     * 估算净值
     */
    private BigDecimal estimateUnitValue;

    /**
     * 估算累计净值
     */
    private BigDecimal estimateTotalUnitValue;

    /**
     * 估算 增长率
     */
    private BigDecimal estimateRisePercent;

    /**
     * 估算时间
     */
    private LocalDateTime estimateTime;


    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }

}
