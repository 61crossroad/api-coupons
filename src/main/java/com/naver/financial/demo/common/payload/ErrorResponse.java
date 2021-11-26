package com.naver.financial.demo.common.payload;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ErrorResponse {
    Integer status;
    String message;
}
