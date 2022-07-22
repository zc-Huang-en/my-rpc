package com.smgeek.gkrpc;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 11:04
 * @Description: 处理网络请求handler
 * @version: 1.0
 */
public interface RequestHandler{
    void onRequest(InputStream recive, OutputStream toResp);
}
