package com.jjq.funda.util;

import com.jjq.funda.db.entity.Fund;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author jiangjunqing
 * @date 2021/11/15
 * @description:
 * @version:
 */
public class BeanUtilsTest {


    @Test
    public void toBeanTest() {

        Fund fund = new Fund();
        fund.setFundCode("012414");
        fund.setFundName("招商中证白酒");
        //fund.setXixi(new Date());
        fund.setId(1);
        fund.setEstablishTime(LocalDateTime.now().toLocalDate());
        OtherFund otherFund = BeanUtils.copyBean(fund, OtherFund.class);
        System.out.println(JsonUtils.toJsonString(otherFund));


    }

    @Test
    public void toBeanListTest() {
        Fund fund = new Fund();
        fund.setFundCode("012414");
        fund.setFundName("招商中证白酒");
        //fund.setXixi(new Date());
        fund.setId(1);
        fund.setEstablishTime(LocalDateTime.now().toLocalDate());

        Fund fund1 = new Fund();
        fund1.setFundCode("012415");
        fund1.setFundName("招商中证白酒");
        //fund1.setXixi(new Date());
        fund1.setId(2);
        fund1.setEstablishTime(LocalDateTime.now().toLocalDate());

        List<Fund> res = ListUtils.newArrayList(fund, fund1);

        System.out.println(JsonUtils.toJsonString(BeanUtils.copyList(res, OtherFund.class)));
    }

    @Test
    public void toBeanListPerformanceTest() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Fund fund = new Fund();
            fund.setFundCode("012414");
            fund.setFundName("招商中证白酒");
            fund.setId(1);
            fund.setEstablishTime(LocalDateTime.now().toLocalDate());
            OtherFund otherFund = BeanUtils.toBean(fund, OtherFund.class);
            //System.out.println(JsonUtils.toJsonString(otherFund));
        }
        System.out.println("my BeanList cost:" + (System.currentTimeMillis()-start));

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Fund fund = new Fund();
            fund.setFundCode("012414");
            fund.setFundName("招商中证白酒");
            fund.setId(1);
            fund.setEstablishTime(LocalDateTime.now().toLocalDate());
            OtherFund otherFund = new OtherFund();
            org.springframework.beans.BeanUtils.copyProperties(fund, otherFund, OtherFund.class);
            //System.out.println(JsonUtils.toJsonString(otherFund));
        }
        System.out.println("spring BeanList cost:" + (System.currentTimeMillis()-start1));
//        my BeanList cost:2985
//        spring BeanList cost:427

    }
}
