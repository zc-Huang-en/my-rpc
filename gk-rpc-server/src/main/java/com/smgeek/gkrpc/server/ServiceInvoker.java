package com.smgeek.gkrpc.server;

import com.smgeek.gkrpc.Request;
import com.smgeek.gkrpc.common.utils.ReflectionUtils;
import com.sun.deploy.util.ReflectionUtil;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 14:23
 * @Description: 调用具体服务
 * @version: 1.0
 */
public class ServiceInvoker{
    public Object invoke(ServiceInstance service, Request request){
        return ReflectionUtils.invoke(service.getTarget(),service.getMethod(),request.getParameters());
    }
}
