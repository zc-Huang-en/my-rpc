package com.smgeek.gkrpc;

import java.io.InputStream;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:59
 * @Description:
 * 1.创建连接
 * 2.发送数据,并且等待响应
 * 3.关闭连接
 * @version: 1.0
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
