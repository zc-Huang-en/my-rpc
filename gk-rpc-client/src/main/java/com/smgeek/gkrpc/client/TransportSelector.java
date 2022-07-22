package com.smgeek.gkrpc.client;

import com.smgeek.gkrpc.Peer;
import com.smgeek.gkrpc.TransportClient;

import java.util.List;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 14:50
 * @Description: 表示选择哪个server路由去连接
 * @version: 1.0
 */
public interface TransportSelector{
    /*
     * @Description: 初始化selector
     * @param peers: 可以连接的server端点信息
     * @param count: 建立多少连接
     * @param clazz: client实现class
     * @return: void
     */
    void init(List<Peer>peers,int count,Class<? extends TransportClient> clazz);
    /*
     * @Description: 选择transport与server做交互
     * @return: 网络client
     */
    TransportClient select();
    /**
     * @Description: 释放用完的client
     * @param client:
     * @return: void
     */
    void release(TransportClient client);

    void close();
}
