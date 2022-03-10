package com.cxytiandi.encrypt_springboot_example.util;



/**
 * 返回类
 **/
public class ResultTool {
    public static JsonResult<?> success() {
        return new JsonResult<>(true);
    }
    public static JsonResult<?>  success(Boolean success,Integer code,String msg) {
        return new JsonResult<>(success,code,msg);
    }
    public static JsonResult<?>  success(ResultCode resultEnum) {
        return new JsonResult<>(true, resultEnum);
    }
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(true, data);
    }
    public static JsonResult<?>  fail(Integer code,String msg) {
        return new JsonResult<>(false,code,msg);
    }
    public static JsonResult<?>  fail() {
        return new JsonResult<>(false);
    }
    public static JsonResult<?>  fail(ResultCode resultEnum) {
        return new JsonResult<>(false, resultEnum);
    }
    public static <T> JsonResult<T> fail(T data) {
        return new JsonResult<T>(false, data);
    }
}
