package com.naver.financial.demo.coupongroup.service;

import com.naver.financial.demo.common.utils.JsonUtils;
import com.naver.financial.demo.coupongroup.entity.CouponGroupHistories;
import com.naver.financial.demo.coupongroup.entity.CouponGroups;
import com.naver.financial.demo.coupongroup.model.CouponGroupStatus;
import com.naver.financial.demo.coupongroup.payload.CouponGroupUpsertRequest;
import com.naver.financial.demo.coupongroup.repository.CouponGroupHistoriesRepository;
import com.naver.financial.demo.coupongroup.repository.CouponGroupsRepository;
import com.naver.financial.demo.user.entity.Users;
import com.naver.financial.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceAlreadyExistsException;
import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Service
public class CouponGroupService {
    private final UserRepository userRepository;
    private final CouponGroupsRepository couponGroupsRepository;
    private final CouponGroupHistoriesRepository couponGroupHistoriesRepository;

    @Transactional
    public CouponGroups create(CouponGroupUpsertRequest request) throws Exception {
        CouponGroups isExists = couponGroupsRepository.findByCode(request.getCode());
        if (isExists != null) {
            throw new InstanceAlreadyExistsException();
        }
        Users issuer = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 없습니다."));

        CouponGroups couponGroup = CouponGroups.builder()
                .issuer(issuer)
                .code(request.getCode())
                .name(request.getName())
                .status(CouponGroupStatus.CREATED)
                .amount(request.getAmount())
                .maxCount(request.getMax_count())
                .currentCount(0)
                .validFromDt(request.getValid_from_dt())
                .validToDt(request.getValid_to_dt())
                .createdAt(OffsetDateTime.now())
                .build();

        couponGroupsRepository.saveAndFlush(couponGroup);

        CouponGroupHistories history = CouponGroupHistories.builder()
                .couponGroup(couponGroup)
                .userId(issuer.getId())
                .data(JsonUtils.toJson(couponGroup))
                .createdAt(OffsetDateTime.now())
                .build();

        couponGroupHistoriesRepository.save(history);

        return couponGroupsRepository.findByCode(request.getCode());
    }
}
