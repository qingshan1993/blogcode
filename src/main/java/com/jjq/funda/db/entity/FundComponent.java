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
 * @desc 基金持仓
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fund_component")
public class FundComponent {

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
     * 持仓股票/债券code
     */
    private String componentCode;

    /**
     * 持仓股票/债券code
     */
    private String componentName;

    /**
     * 持仓类型.stock=股票, xxx=债券
     */
    private String componentType;

    /**
     * 持仓比例
     */
    private BigDecimal percent;

    /**
     * 持仓公布日期
     */
    private LocalDate publishDate;

    /**
     * 增长幅度
     */
    private BigDecimal raisePercent;

    /**
     * 增长幅度更新时间
     */
    private LocalDateTime raiseUpdateTime;

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }


}
