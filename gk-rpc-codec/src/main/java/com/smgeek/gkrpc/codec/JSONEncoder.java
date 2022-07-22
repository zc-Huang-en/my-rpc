package com.smgeek.gkrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:38
 * @Description: 基于json的序列化实现
 * @version: 1.0
 */
public class JSONEncoder implements Encoder{
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
