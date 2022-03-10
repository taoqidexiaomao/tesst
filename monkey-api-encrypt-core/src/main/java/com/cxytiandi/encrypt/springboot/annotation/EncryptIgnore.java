package com.cxytiandi.encrypt.springboot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *    忽略加密注解
 * 
 * <p>加了此注解的接口将不进行数据加密操作
 * <p>适用于全局开启加解密操作，但是想忽略某些接口场景
 * 
 * @author yinjihuan http://cxytiandi.com/about
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptIgnore {

	String value() default "";
	
}
