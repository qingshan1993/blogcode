package com.jjq.funda.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/2
 * @desc 添加或者更新基金
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("基金新增和更新vo")
public class AddOrUpdateFundItemVO implements Serializable {

    @ApiModelProperty(value = "主键ID")
    @NotNull(message = "id不能为空", groups = AddOrUpdateFundItemVO.updateGroup.class)
    private Integer id;

    /**
     * 基金编码
     */
    @ApiModelProperty(value = "基金code")
    @NotBlank(message = "基金编码不能为空")
    private String fundCode;

    /**
     * 基金名称
     */
    @ApiModelProperty(value = "基金名称")
    @NotBlank(message = "基金名称不能为空")
    private String fundName;

    /**
     * 基金状态
     */
    @ApiModelProperty(value = "基金状态")
    @NotBlank(message = "基金状态不能为空")
    private String status;

    /**
     * 基金成立日期
     */
    @ApiModelProperty(value = "基金成立日期")
    @NotNull(message = "基金成立日期不能为空")
    @Past(message = "基金成立日期不能大于当前日期")
    private LocalDate establishDate;


    public interface AddGroup {

    }

    public interface updateGroup {

    }
}
