package com.test.platform.hawkeye.domain.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> {
    private Integer code;
    private String message;
    private T data;
}
