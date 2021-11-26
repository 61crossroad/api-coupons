package com.naver.financial.demo.coupongroup.entity;

import com.naver.financial.demo.coupongroup.model.CouponGroupStatus;
import com.naver.financial.demo.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CouponGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "issuer_id")
    private Users issuer;

    private String code;

    private String name;

    private CouponGroupStatus status;

    private Integer amount;

    private Integer maxCount;

    private Integer currentCount;

    private OffsetDateTime validFromDt;

    private OffsetDateTime validToDt;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
