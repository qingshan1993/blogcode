package com.jjq.funda.db.repo;

import com.jjq.funda.db.entity.AccessLog;
import com.jjq.funda.db.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jiangjunqing
 * @date 2022/7/27
 * @description: 系统访问日志
 * @version:
 */
@Repository
public interface AccessLogRepo extends JpaRepository<AccessLog, Long> {

}




