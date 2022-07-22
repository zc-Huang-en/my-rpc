package com.smgeek.gkrpc;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 11:02
 * @Description:
 * 1.启动监听端口
 * 2.接受请求
 * 3.关闭监听
 * @version: 1.0
 */
public interface TransportServer{
    void init(int port,RequestHandler handler);

    void start();

    void stop();
}
