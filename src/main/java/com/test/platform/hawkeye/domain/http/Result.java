package com.test.platform.hawkeye.domain.http;


import com.test.platform.hawkeye.exception.BaseException;

public class Result {

    private static final String SUCCESS = "SUCCESS";

    private static final String ERROR = "ERROR";

    private static final ResponseMessage RESPONSE_MESSAGE_SUCCESS = new ResponseMessage(ResponseMessageCodeEnum.SUCCESS.getCode(), "", null);


    public static ResponseMessage success() {
        return RESPONSE_MESSAGE_SUCCESS;
    }

    public static <T> ResponseMessage<T> success(T t) {
        return new ResponseMessage(ResponseMessageCodeEnum.SUCCESS.getCode(), "SUCCESS", t);
    }

    public static ResponseMessage success(String result) {
        return new ResponseMessage(ResponseMessageCodeEnum.SUCCESS.getCode(), "SUCCESS", result);
    }

    public static ResponseMessage error() {
        return error(ERROR);
    }

    public static ResponseMessage error(String message) {
        return error(ResponseMessageCodeEnum.ERROR.getCode(), message);
    }

    public static ResponseMessage error(BaseException baseException) {
        return error(baseException.getErrorCode(), baseException.getMessage());
    }

    public static ResponseMessage error(Integer code, String message) {
        return error(code, message, null);
    }

    public static <T> ResponseMessage<T> error(Integer code, String message, T t) {
        return new ResponseMessage(code, message, t);
    }

}
