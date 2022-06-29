package com.jjq.funda.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author jiangjunqing
 * @date 2021/11/15
 * @description:
 * @version:
 */
@Getter
@Setter
@RequiredArgsConstructor
public class OtherFund {

    private Integer id;

    private String fundCode;

    private String fundName;

    private String status;

    private LocalDateTime establishTime;

    private BigDecimal value = BigDecimal.ZERO;

    private Date xixi;
}
