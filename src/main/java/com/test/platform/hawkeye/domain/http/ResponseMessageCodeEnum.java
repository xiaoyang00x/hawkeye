package com.test.platform.hawkeye.domain.http;

public enum ResponseMessageCodeEnum {

    SUCCESS(0),
    ERROR(-1),
    VALID_ERROR(1000),
    RE_LOGIN(999);

    private Integer code;

    ResponseMessageCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
