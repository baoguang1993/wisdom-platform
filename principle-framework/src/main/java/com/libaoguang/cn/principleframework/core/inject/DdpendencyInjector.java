package com.libaoguang.cn.principleframework.core.inject;

import com.libaoguang.cn.principleframework.core.BeanContainer;
import com.libaoguang.cn.principleframework.utils.ClassUtils;

import java.lang.reflect.Field;
import java.util.Set;

public class DdpendencyInjector {
    private BeanContainer beanContainer;

    public DdpendencyInjector(BeanContainer beanContainer) {
        this.beanContainer = beanContainer;
    }

    public DdpendencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行 IOC
     * 1.遍历bean容器中所有的class对象
     * 2.遍历class对象的所有成员变量
     * 3.找出Autowired标记的所有成员变量
     * 4.取出这些成员变量的类型
     * 5.获取这些成员变量在容器里面的实例
     * 6.通过反射将这些成员变量的实例注入到成员变量所在的类
     */
    public void doIoc() {
        Set<Class<?>> classes = beanContainer.getClasses();
        if (classes == null || classes.isEmpty()) {
            return;
        }

        for (Class<?> clazz : beanContainer.getClasses()) {
            Field[] fields = clazz.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        Autowired autowired = field.getAnnotation(Autowired.class);
                        String value = autowired.value();
                        Class<?> type = field.getType();
                        Object fieldValues = getFieldInstance(type, value);
                        if (fieldValues == null) {
                            throw new RuntimeException("获取实例异常");
                        } else {
                            Object targetBean = beanContainer.getBean(clazz);
                            ClassUtils.setFile(field, targetBean, fieldValues, true);
                        }
                    }
                }
            }

        }
    }

    public Object getFieldInstance(Class<?> fieldClass, String value) {
        Object fieldvalue = beanContainer.getBean(fieldClass);
        if (fieldvalue != null) {
            return fieldvalue;
        }
        Class<?> impleteClass = getImpleteClass(fieldClass, value);
        if (impleteClass != null) {
            return beanContainer.getBean(impleteClass);
        } else {
            return null;
        }
    }

    private Class<?> getImpleteClass(Class<?> fieldClass, String value) {
        Set<Class<?>> classBySuper = beanContainer.getClassBySuper(fieldClass);
        if (classBySuper == null || classBySuper.isEmpty()) {
            return null;
        }
        if (classBySuper.size() == 1) {
            return classBySuper.iterator().next();
        } else {
            //判断
            for (Class<?> clazz : classBySuper) {
                String simpleName = clazz.getSimpleName();
                if (simpleName.equals(value)) {
                    return clazz;
                } else {
                    throw new RuntimeException("bean 实例不唯一");
                }
            }

        }
        return null;
    }
}
