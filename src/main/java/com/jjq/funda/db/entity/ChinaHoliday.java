package com.jjq.funda.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/23
 * @desc 节假日 https://timor.tech/api/holiday/
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "china_holiday")
public class ChinaHoliday {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * 日期
     */

    private LocalDate date;

    /**
     * 节假日描述
     */
    private String desc;
}
