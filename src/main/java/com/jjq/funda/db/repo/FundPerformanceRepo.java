package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.FunPerformance;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/4
 * @desc 基金业绩
 */
@Repository
public interface FundPerformanceRepo extends JpaRepository<FunPerformance, Integer>  {


    /**
     * 根据指定基金编码查询
     * @param fundCode
     * @return
     */
    @Query (value = "select max(fund_date) from fund_performance where fund_code =:fundCode", nativeQuery = true)
    LocalDate findMaxFundDateByFundCode(String fundCode);


}
