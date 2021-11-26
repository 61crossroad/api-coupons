package com.naver.financial.demo.coupongroup.repository;

import com.naver.financial.demo.coupongroup.entity.CouponGroups;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CouponGroupsRepositoryTest {
    @Autowired
    private CouponGroupsRepository repository;

    @Test
    public void test() {
        CouponGroups entity = repository.findByCode("CP1000");
        System.out.println();
    }
}
