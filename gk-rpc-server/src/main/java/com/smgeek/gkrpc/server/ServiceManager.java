package com.smgeek.gkrpc.server;

import com.smgeek.gkrpc.Request;
import com.smgeek.gkrpc.ServiceDescriptor;
import com.smgeek.gkrpc.common.utils.ReflectionUtils;
import com.sun.deploy.util.ReflectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 13:16
 * @Description: 管理rpc暴露的服务
 * @version: 1.0
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    public<T> void register(Class<T> interfaceClass,T bean){
        //接口的class，以及实现了该接口的子类对象
        //把接口里面所有的方法都注册到当前的服务器中
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for(Method method:methods){
            ServiceInstance sis = new ServiceInstance(bean,method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass,method);
            services.put(sdp,sis);
            log.info("register service: {} {}",sdp.getClazz(),sdp.getMethod());
        }
    }
    /*
     * @Description: 获取所有注册的接口
     * @return: com.smgeek.gkrpc.server.ServiceInstance
     */
    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
