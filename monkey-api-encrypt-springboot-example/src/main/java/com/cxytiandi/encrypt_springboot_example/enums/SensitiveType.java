package com.cxytiandi.encrypt_springboot_example.enums;

/**
 * 敏感数据类型
 */
public enum SensitiveType {
    /**
     * 姓名
     */
    CHINESE_NAME,
    /**
     * 身份证
     */
    ID_CARD,
    /**
     * 座机号
     */
    LANDLINE_NUMBER,
    /**
     * 手机
     */
    PHONE_NUMBER,
    /**
     * 地址
     */
    ADDRESS,
    /**
     * 邮箱
     */
    EMAIL,
    /**
     * 密码
     */
    PASSWORD,
    /**
     * 中国大陆车牌，包含普通车辆、新能源车辆
     */
    LICENSE_PLATE,
    /**
     * 银行卡
     */
    BANK_CARD
}
