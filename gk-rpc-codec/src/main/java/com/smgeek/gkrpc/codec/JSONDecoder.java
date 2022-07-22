package com.smgeek.gkrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:39
 * @Description: 基于json的反序列化实现
 * @version: 1.0
 */
public class JSONDecoder implements Decoder{

    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
