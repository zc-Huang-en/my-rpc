package com.smgeek.gkrpc.server;

import com.smgeek.gkrpc.HTTPTransportServer;
import com.smgeek.gkrpc.TransportServer;
import com.smgeek.gkrpc.codec.Decoder;
import com.smgeek.gkrpc.codec.Encoder;
import com.smgeek.gkrpc.codec.JSONDecoder;
import com.smgeek.gkrpc.codec.JSONEncoder;
import lombok.Data;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 13:10
 * @Description: server配置
 * @version: 1.0
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
