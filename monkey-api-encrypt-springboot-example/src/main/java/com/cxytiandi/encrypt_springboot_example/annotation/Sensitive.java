package com.cxytiandi.encrypt_springboot_example.annotation;



import com.cxytiandi.encrypt_springboot_example.enums.SensitiveType;
import com.cxytiandi.encrypt_springboot_example.serialize.SensitiveSerialize;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 敏感字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveSerialize.class)
public @interface Sensitive {
    SensitiveType value();
}
