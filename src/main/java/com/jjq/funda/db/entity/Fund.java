package com.jjq.funda.db.entity;

import com.jjq.funda.util.JsonUtils;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/5
 * @desc 基金
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fund")
public class Fund extends BaseEntity {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * 基金编码
     */
    private String fundCode;

    /**
     * 基金名称
     */
    private String fundName;

    /**
     * 基金经理名称
     */
    private String manager;

    /**
     * 基金状态
     */
    private String status;

    /**
     * 基金成立世界
     */
    private LocalDate establishDate;

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}
