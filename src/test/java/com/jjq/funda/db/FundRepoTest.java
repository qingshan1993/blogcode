package com.jjq.funda.db;

import com.jjq.funda.FundaApplicationTests;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.db.repo.FundRepo;
import com.jjq.funda.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/4
 * @desc
 */
@Slf4j
public class FundRepoTest extends FundaApplicationTests {

    @Autowired
    public FundRepo fundRepo;

    /**
     * 保存单挑记录测试
     */
    @Test
    public void saveFundTest() {
        Fund fund = Fund.builder()
                .fundCode("003096")
                .fundName("中欧医疗健康混合C")
                .status("onSale")
                .establishDate(LocalDate.now())
                .build();
        Fund save = fundRepo.save(fund);
        log.info("保存基金记录成功，保存后记录fund：{}", JsonUtils.toJsonString(save));
    }

    /**
     * 保存单挑记录测试
     */
    @Test
    public void selectOneFundTest() {
        Optional<Fund> byId = fundRepo.findById(1);
        log.info("保存基金记录成功，保存后记录fund：{}", JsonUtils.toJsonString(byId.get()));
    }

}
