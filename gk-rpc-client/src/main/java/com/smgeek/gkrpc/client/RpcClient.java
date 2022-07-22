package com.smgeek.gkrpc.client;

import com.smgeek.gkrpc.codec.Decoder;
import com.smgeek.gkrpc.codec.Encoder;
import com.smgeek.gkrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 15:27
 * @Description: com.smgeek.gkrpc.client
 * @version: 1.0
 */
public class RpcClient{
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        //默认配置
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(this.config.getServers(),this.config.getConnectCount(),this.config.getTransportClass());

    }

    public <T>T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz,encoder,decoder,selector));
    }
}
