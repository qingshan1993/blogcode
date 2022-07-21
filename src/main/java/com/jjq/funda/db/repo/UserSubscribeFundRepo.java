package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.FunPerformance;
import com.jjq.funda.db.entity.UserSubscribeFund;
import com.jjq.funda.model.enums.DataState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/19
 * @desc 用户订阅基金列表
 */
@Repository
public interface UserSubscribeFundRepo extends JpaRepository<UserSubscribeFund, Integer> {

    /**
     * 获取用户已订阅的基金code
     * @return
     */
    @Query(value = "select distinct(fund_code) from user_subscribe_fund " +
            "where subscribe_status='VALID'", nativeQuery = true)
    List<String> listUserSubscribedFundCode();


}
