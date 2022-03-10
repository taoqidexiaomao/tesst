package com.cxytiandi.encrypt_springboot_example.util;

/*
 * 返回枚举
 **/
public enum ResultCode {
    /* 成功 */
    SUCCESS(200, "操作成功"),
    /* 默认失败 */
    COMMON_FAIL(400, "操作失败");
    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据code获取message
     */
    public static String getMessageByCode(Integer code) {
        for (ResultCode ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }
}
