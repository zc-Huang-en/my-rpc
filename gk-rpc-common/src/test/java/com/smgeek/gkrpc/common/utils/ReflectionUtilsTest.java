package com.smgeek.gkrpc.common.utils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:14
 * @Description: com.smgeek.gkrpc.common.utils
 * @version: 1.0
 */

public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);//测试是否可实例化完成
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);
        String mname = methods[0].getName();
        assertEquals("b",mname);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];
        TestClass t = new TestClass();
        Object obj = ReflectionUtils.invoke(t,b);
        assertEquals("b",obj);
    }
}
