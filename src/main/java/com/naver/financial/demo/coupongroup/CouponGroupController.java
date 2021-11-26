package com.naver.financial.demo.coupongroup;

import com.naver.financial.demo.common.payload.ApiResponse;
import com.naver.financial.demo.common.service.HeaderService;
import com.naver.financial.demo.coupongroup.entity.CouponGroups;
import com.naver.financial.demo.coupongroup.payload.CouponGroupUpsertRequest;
import com.naver.financial.demo.coupongroup.payload.CouponGroupUpsertResponse;
import com.naver.financial.demo.coupongroup.service.CouponGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/coupon-groups/{code}")
public class CouponGroupController {

    private final HeaderService headerService;
    private final CouponGroupService service;

    @PostMapping
    public ResponseEntity<ApiResponse<CouponGroupUpsertResponse>> create(@RequestHeader Map<String, String> headers,
                                                            @PathVariable("code") String code,
                                                            @RequestBody CouponGroupUpsertRequest request) throws Exception {
        String userId = headerService.getUserId(headers);
        request.setUserId(userId);
        request.setCode(code);
        CouponGroups couponGroup = service.create(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.of(
                        true,
                        CouponGroupUpsertResponse.of(couponGroup),
                        null));
    }

}
