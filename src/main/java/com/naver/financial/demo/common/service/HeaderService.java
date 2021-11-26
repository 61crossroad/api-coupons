package com.naver.financial.demo.common.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HeaderService {

    public String getUserId(Map<String, String> headers) {
        String userId = headers.get("x-user-id");
        if (userId == null) {
            throw new IllegalArgumentException("user_id가 없습니다.");
        }

        return userId;
    }
}
