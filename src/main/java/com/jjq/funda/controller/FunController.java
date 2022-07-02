package com.jjq.funda.controller;

import com.jjq.funda.model.RespResult;
import org.springframework.validation.annotation.Validated;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
@Validated
public class FunController {



    public RespResult<Boolean> addFunds() {

        return RespResult.success(true);

    }

}
