package com.jjq.funda.service;

import com.jjq.funda.db.entity.FunPerformance;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/4
 * @desc 基金业绩服务
 */
@Service
public class FundPerformanceService {


    /**
     * 保存或者更新列表
     * @param funPerformanceList
     * @param fundCode funPerformanceList是同一个fundCode, 不同的将被过滤
     */
    public void saveOrUpdateEntities(List<FunPerformance> funPerformanceList, String fundCode) {
        //根据fundCode和fundDate查询

    }

}
