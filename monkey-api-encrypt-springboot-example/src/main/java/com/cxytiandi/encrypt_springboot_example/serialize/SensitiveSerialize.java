package com.cxytiandi.encrypt_springboot_example.serialize;


import cn.hutool.core.util.DesensitizedUtil;
import com.cxytiandi.encrypt_springboot_example.annotation.Sensitive;
import com.cxytiandi.encrypt_springboot_example.enums.SensitiveType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 敏感数据类型序列化处理类
 */
@Slf4j
public class SensitiveSerialize extends JsonSerializer<String> implements ContextualSerializer {


    private SensitiveType type;


    public SensitiveSerialize(SensitiveType type) {
        this.type = type;
    }

    public SensitiveSerialize() {
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty property) throws JsonMappingException {

        // 为空直接跳过
        if (property != null) {
            // 非 String 类直接跳过
            if (Objects.equals(property.getType().getRawClass(), String.class)) {
                Sensitive sensitive = property.getAnnotation(Sensitive.class);
                if (sensitive == null) {
                    sensitive = property.getContextAnnotation(Sensitive.class);
                }
                // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
                if (sensitive != null) {
                    return new SensitiveSerialize(sensitive.value());
                }
            }
            return serializerProvider.findValueSerializer(property.getType(), property);
        } else {
            return serializerProvider.findNullValueSerializer(null);
        }
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) {
        try {
            switch (this.type) {
                case CHINESE_NAME:
                    gen.writeString(DesensitizedUtil.chineseName(value));break;
                case ID_CARD:
                    gen.writeString(DesensitizedUtil.idCardNum(value, 5, 4));break;
                case LANDLINE_NUMBER:
                    gen.writeString(DesensitizedUtil.fixedPhone(value));break;
                case PHONE_NUMBER:
                    gen.writeString(DesensitizedUtil.mobilePhone(value));break;
                case ADDRESS:
                    gen.writeString(DesensitizedUtil.address(value, 2));break;
                case EMAIL:
                    gen.writeString(DesensitizedUtil.email(value));break;
                case PASSWORD:
                    gen.writeString(DesensitizedUtil.password(value));break;
                case LICENSE_PLATE:
                    gen.writeString(DesensitizedUtil.carLicense(value));break;
                case BANK_CARD:
                    gen.writeString(DesensitizedUtil.bankCard(value));break;
            }
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }

    }
}
