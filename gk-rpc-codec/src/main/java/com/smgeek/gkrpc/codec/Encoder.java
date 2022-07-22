package com.smgeek.gkrpc.codec;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:33
 * @Description: 序列化
 * @version: 1.0
 */
public interface Encoder{
    byte[] encode(Object obj);
}
