package com.test.platform.hawkeye.domain.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultResponse<T> {
    private Integer code;
    private String message;
    private T data;
}
