package com.naver.financial.demo.coupon.entity;

import com.naver.financial.demo.coupon.model.CouponStatus;
import com.naver.financial.demo.user.entity.Users;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class Coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    private CouponStatus status;

    private Long amount;

    private OffsetDateTime validFromDt;

    private OffsetDateTime validToDt;

    private OffsetDateTime used_at;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
