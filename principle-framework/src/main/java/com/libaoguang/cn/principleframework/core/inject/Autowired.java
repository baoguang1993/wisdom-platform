package com.libaoguang.cn.principleframework.core.inject;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    /**
     * 用于处理类是实例不唯一的场景
     * @return
     */
   String value() default "" ;
}
