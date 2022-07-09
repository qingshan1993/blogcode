package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.FunPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/4
 * @desc 基金业绩
 */
@Repository
public interface FundPerformanceRepo extends JpaRepository<FunPerformance, Integer>  {
}
