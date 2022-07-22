package com.smgeek.gkrpc;

import lombok.Data;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 9:51
 * @Description: 表示RPC的一个请求
 * @version: 1.0
 */
@Data
public class Request{
    private ServiceDescriptor service;//client需要请求什么服务
    private Object[] parameters;//调用需要传参数
}
