package com.smgeek.gkrpc.codec;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:34
 * @Description: 反序列化
 * @version: 1.0
 */
public interface Decoder{
    <T>T decode(byte[] bytes,Class<T> clazz);
}
