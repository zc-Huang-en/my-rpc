package com.smgeek.gkrpc.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:00
 * @Description: 反射工具类
 * @version: 1.0
 */
public class ReflectionUtils{
    /*
     * @Description: 根据class创建对象
     * @param clazz: 待创建对象类
     * @return: T 对象类型
     */
    public static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /*
     * @Description: 获取某个class的共有方法
     * @param clazz:
     * @return: 当前类的公共方法
     */
    public static Method[] getPublicMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();//返回当前类所有方法
        List<Method> pmethods = new ArrayList<>();
        for(Method m:methods){
            if(Modifier.isPublic(m.getModifiers())){
                pmethods.add(m);//把public的方法拿到并返回
            }
        }
        return pmethods.toArray(new Method[0]);
    }
    /*
     * @Description: 调用指定对象的指定方法
     * @param obj: 被调用方法的对象
     * @param method: 被调用的方法
     * @param args: 参数
     * @return: 返回结果
     */
    public static Object invoke(Object obj,Method method,Object... args){
        try {
            return method.invoke(obj,args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
