package com.smgeek.gkrpc.codec;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 10:43
 * @Description: com.smgeek.gkrpc.codec
 * @version: 1.0
 */
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setAge(18);
        bean.setName("smgeek");
        byte[]bytes = encoder.encode(bean);
        Decoder decoder = new JSONDecoder();
        TestBean bean1 = decoder.decode(bytes,TestBean.class);
        assertEquals(18,bean1.getAge());
        assertEquals("smgeek",bean1.getName());
    }
}
