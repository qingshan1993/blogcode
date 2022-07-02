package com.jjq.funda.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/2
 * @desc 添加或者更新基金
 */
public class AddOrUpdateFundItemVO implements Serializable {


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
     * 基金状态
     */
    private String status;

    /**
     * 基金成立世界
     */
    private LocalDate establishTime;


    public interface AddGroup {

    }

    public interface updateGroup {

    }
}
