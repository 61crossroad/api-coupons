package com.naver.financial.demo.coupongroup.payload;

import com.naver.financial.demo.coupongroup.entity.CouponGroups;
import com.naver.financial.demo.coupongroup.model.CouponGroupStatus;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

@Builder
@Value
public class CouponGroupUpsertResponse {
    Long id;
    String issuer_id;
    String code;
    String name;
    CouponGroupStatus status;
    Integer amount;
    Integer max_count;
    Integer current_count;
    OffsetDateTime valid_from_dt;
    OffsetDateTime valid_to_dt;
    OffsetDateTime created_at;
    OffsetDateTime updated_at;

    public static CouponGroupUpsertResponse of(CouponGroups entity) {
        return CouponGroupUpsertResponse.builder()
                .id(entity.getId())
                .issuer_id(entity.getIssuer().getId())
                .code(entity.getCode())
                .name(entity.getName())
                .status(entity.getStatus())
                .amount(entity.getAmount())
                .max_count(entity.getMaxCount())
                .current_count(entity.getCurrentCount())
                .valid_from_dt(entity.getValidFromDt())
                .valid_to_dt(entity.getValidToDt())
                .created_at(entity.getCreatedAt())
                .updated_at(entity.getUpdatedAt() != null ?
                        entity.getUpdatedAt() :
                        null)
                .build();
    }
}
