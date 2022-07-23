package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.ChinaHoliday;
import com.jjq.funda.db.entity.FundComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/23
 * @desc
 */
@Repository
public interface ChinaHolidayRepo extends JpaRepository<ChinaHoliday, Integer> {

    /**
     * 根据日期获取记录
     * @return
     */
    ChinaHoliday findOneByDate();
}
