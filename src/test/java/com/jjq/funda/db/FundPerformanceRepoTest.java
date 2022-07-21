package com.jjq.funda.db;

import com.jjq.funda.FundaApplicationTests;
import com.jjq.funda.db.repo.FundPerformanceRepo;
import com.jjq.funda.db.repo.UserSubscribeFundRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/21
 * @desc
 */
@Slf4j
public class FundPerformanceRepoTest extends FundaApplicationTests {

    @Autowired
    public FundPerformanceRepo fundPerformanceRepo;

    /**
     * 保存单挑记录测试
     */
    @Test
    public void listUserSubscribedFundCodeTest() {
        LocalDate maxFundDateByFundCode = fundPerformanceRepo.findMaxFundDateByFundCode("003096");
        log.info(":::::::::result:{}", maxFundDateByFundCode);
    }
}
