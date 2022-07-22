package com.smgeek.gkrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 13:15
 * @Description: 具体服务
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
