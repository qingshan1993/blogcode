package com.jjq.funda.model.dto;

import com.jjq.funda.util.JsonUtils;
import com.jjq.funda.model.vo.AddOrUpdateFundItemVO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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
public class AddOrUpdateFundDTO extends BaseReqDTO implements Serializable {
    private static final long serialVersionUID = 1259169803536342231L;

    /**
     * 数据创建时间
     */
    private Long creatorId;

    /**
     * 更新人ID
     */
    private Long updaterId;


    private List<AddOrUpdateFundItemVO> itemVOList;


    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}
