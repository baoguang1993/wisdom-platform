package com.libaoguang.cn.principleframework.utils;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ClassUtils {
    public static final String FILE_TYPE = "file";

    /**
     * 获取包下面类的集合
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> greedyPackegesClass(String packageName) {
        ClassLoader classLoader = getClassLoader();
        URL resource = classLoader.getResource(packageName.replace(".", "/"));
        if (null == resource) {
            return null;
        }
        Set<Class<?>> classSet = null;
        if (resource.getProtocol().equalsIgnoreCase(FILE_TYPE)) {
            classSet = new HashSet<Class<?>>();
            File packageDirectory = new File(resource.getPath());
            greedyPackegesClassFile(classSet, packageDirectory, packageName);
        }
        return classSet;
    }

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private static void greedyPackegesClassFile(Set<Class<?>> emptyclassSet, File fileDirectory, String packageName) {
        if (!fileDirectory.isDirectory()) {
            return;
        }
        File[] files = fileDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        addToClassSet(absolutePath);
                    }
                }


                return false;
            }

            private void addToClassSet(String absolutePath) {
                //获取class路径
                //获取类名具体路径
                //获取类
                //add  to SET
                absolutePath = absolutePath.replace(File.separator, ".");
                String className = absolutePath.substring(absolutePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf("."));
                Class aClass = loadClass(className);
                emptyclassSet.add(aClass);
            }
        });
        if (files != null) {
            for (File file : files) {
                greedyPackegesClassFile(emptyclassSet, fileDirectory, packageName);
            }
        }

    }

    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取类的实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T newInstance(Class<?> clazz, boolean flag) {
        try {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(flag);

            try {
                return (T) declaredConstructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }
    public static void setFile(Field file,Object target,Object value,boolean accessilbe){
        file.setAccessible(accessilbe);
        try {
            file.set(target,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
