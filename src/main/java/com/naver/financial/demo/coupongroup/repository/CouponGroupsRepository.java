package com.naver.financial.demo.coupongroup.repository;

import com.naver.financial.demo.coupongroup.entity.CouponGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponGroupsRepository extends JpaRepository<CouponGroups, Long> {
    CouponGroups findByCode(String code);
}
