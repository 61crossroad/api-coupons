package com.naver.financial.demo.coupongroup.payload;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CouponGroupUpsertRequest {
    private String userId;
    private String name;
    private String code;
    private Integer amount;
    private Integer max_count;
    private OffsetDateTime valid_from_dt;
    private OffsetDateTime valid_to_dt;
}
