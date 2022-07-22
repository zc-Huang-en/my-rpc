package com.smgeek.gkrpc.server;

import com.smgeek.gkrpc.Request;
import com.smgeek.gkrpc.ServiceDescriptor;
import com.smgeek.gkrpc.common.utils.ReflectionUtils;
import com.sun.deploy.util.ReflectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 14:14
 * @Description: com.smgeek.gkrpc.server
 * @version: 1.0
 */
public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init(){
        sm =  new ServiceManager();
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);//把方法注册到服务器中
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);//把方法注册到服务器中
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class,method);
        Request request = new Request();
        request.setService(sdp);
        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}
