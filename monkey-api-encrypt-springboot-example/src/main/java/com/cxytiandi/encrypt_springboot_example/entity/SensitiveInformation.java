package com.cxytiandi.encrypt_springboot_example.entity;


import com.cxytiandi.encrypt_springboot_example.annotation.Sensitive;
import com.cxytiandi.encrypt_springboot_example.enums.SensitiveType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SensitiveInformation {
    /**
     * 用户id
     */
    private String userid;
    /**
     * 中文姓名
     */
    @Sensitive(SensitiveType.CHINESE_NAME)
    private String chineseName;
    /**
     * 身份证号
     */
    @Sensitive(SensitiveType.ID_CARD)
    private String idNumber;
    /**
     * 座机号
     */
    @Sensitive(SensitiveType.LANDLINE_NUMBER)
    private String landlineNumber;
    /**
     * 手机号
     */
    @Sensitive(SensitiveType.PHONE_NUMBER)
    private String phoneNumber;
    /**
     * 地址
     */
    @Sensitive(SensitiveType.ADDRESS)
    private String address;
    /**
     * 电子邮件
     */
    @Sensitive(SensitiveType.EMAIL)
    private String email;
    /**
     * 密码
     */
    @Sensitive(SensitiveType.PASSWORD)
    private String password;
    /**
     * 中国大陆车牌，包含普通车辆、新能源车辆
     */
    @Sensitive(SensitiveType.LICENSE_PLATE)
    private String licensePlate;
    /*
      银行卡
     */
    @Sensitive(SensitiveType.BANK_CARD)
    private String bankCard;
}
