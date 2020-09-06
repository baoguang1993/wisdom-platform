package com.libaoguang.cn.principleframework.core;

import com.libaoguang.cn.principleframework.core.annotation.Component;
import com.libaoguang.cn.principleframework.core.annotation.Controller;
import com.libaoguang.cn.principleframework.core.annotation.Repository;
import com.libaoguang.cn.principleframework.core.annotation.Service;
import com.libaoguang.cn.principleframework.utils.ClassUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    private boolean loaded = false;
    /**
     * 定义用于存放bean的集合
     */
    private final ConcurrentHashMap<Class<?>, Object> beanHashMap = new ConcurrentHashMap();

    /**
     * 加载配置的集合 公共访问
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    private enum ContainerHolder {
        HOLDER;
        private BeanContainer beanContainer;

        ContainerHolder() {
            beanContainer = new BeanContainer();
        }
    }

    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.beanContainer;
    }

    /**
     * 扫描加载所有的bean
     */
    public synchronized void loadBean(String pageageName) {
        if (isLoaded()) {
            return;
        }
        Set<Class<?>> classes = ClassUtils.greedyPackegesClass(pageageName);
        if (classes == null || classes.isEmpty()) {
            return;
        }
        for (Class<?> clazz : classes) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                if (clazz.isAnnotationPresent(annotation)) {
                    beanHashMap.put(clazz, ClassUtils.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }


    public boolean isLoaded() {
        return loaded;
    }

    public Object addBean(Class<?> clazz, Object bean) {
        return beanHashMap.put(clazz, bean);
    }

    public Object removeBean(Class<?> clazz) {
        return beanHashMap.remove(clazz);
    }

    public Object getBean(Class<?> clazz) {
        return beanHashMap.get(clazz);
    }

    public Set<Class<?>> getClasses() {
        return beanHashMap.keySet();
    }

    public Set<Object> getBeans() {
        return new HashSet<>(beanHashMap.values());
    }

    public Set<Class<?>> getClassByAnnotation(Class<? extends Annotation> annotation) {
        Set<Class<?>> classes = getClasses();
        if (classes == null || classes.isEmpty()) {
            return null;
        }
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
            ;
        }
        return classSet.size() > 0 ? classSet : null;
    }
    public Set<Class<?>> getClassBySuper(Class<?> interfaceOrClass) {
        Set<Class<?>> classes = getClasses();
        if (classes == null || classes.isEmpty()) {
            return null;
        }
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : classes) {
            if(interfaceOrClass.isAssignableFrom(clazz)){
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

}
