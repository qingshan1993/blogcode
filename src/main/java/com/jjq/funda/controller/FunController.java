package com.jjq.funda.controller;

import com.jjq.funda.model.RespResult;
import com.jjq.funda.util.JsonUtils;
import com.jjq.funda.vo.AddOrUpdateFundItemVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */

@Api(tags = "基金管理模块")
@Slf4j
@ResponseBody
@Controller
//@Valid
public class FunController {


    @PostMapping("/funds")
    public RespResult<Boolean> addFunds(@RequestBody List<AddOrUpdateFundItemVO> voList) {
        log.info("addFunds,voList:{}", JsonUtils.toJsonString(voList));
        return RespResult.success(true);
    }

    @PostMapping("/fund")
    public RespResult<Boolean> addFund(@RequestBody @Valid AddOrUpdateFundItemVO itemVO) {
        log.info("addFund,itemVO:{}", JsonUtils.toJsonString(itemVO));
        return RespResult.success(true);
    }


}
