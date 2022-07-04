package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jiangjunqing
 * @date 2021/11/15
 * @description: fund的repository
 * @version:
 */
@Repository
public interface FundRepo  extends JpaRepository<Fund, Integer>
{

}




