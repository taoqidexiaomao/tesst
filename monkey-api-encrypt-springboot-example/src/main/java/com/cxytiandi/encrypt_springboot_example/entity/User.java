package com.cxytiandi.encrypt_springboot_example.entity;


import com.cxytiandi.encrypt_springboot_example.annotation.Sensitive;
import com.cxytiandi.encrypt_springboot_example.enums.SensitiveType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    @Sensitive(SensitiveType.CHINESE_NAME)
    private String name;
    private Integer age;
    @Sensitive(SensitiveType.CHINESE_NAME)
    private Integer sex;
}
