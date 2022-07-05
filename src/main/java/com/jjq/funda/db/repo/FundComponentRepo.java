package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.FundComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/4
 * @desc 基金持仓
 */
@Repository
public interface FundComponentRepo extends JpaRepository<FundComponent, Integer> {
}
