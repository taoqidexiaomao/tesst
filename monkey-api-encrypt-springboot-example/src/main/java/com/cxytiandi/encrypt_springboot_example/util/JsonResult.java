package com.cxytiandi.encrypt_springboot_example.util;



import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回实体
 **/
@Data
public class JsonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public JsonResult(Boolean success, Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public JsonResult(boolean success) {
        this.code = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.message = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
    }

    public JsonResult(boolean success, ResultCode resultEnum) {
        this.code = success ? ResultCode.SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.message = success ? ResultCode.SUCCESS.getMessage() : (resultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : resultEnum.getMessage());
    }

    public JsonResult(boolean success, T data) {
        this.code = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.message = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
        this.data = data;
    }

    public JsonResult() {
    }
}
