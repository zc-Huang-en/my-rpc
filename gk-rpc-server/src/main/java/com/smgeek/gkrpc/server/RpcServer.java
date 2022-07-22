package com.smgeek.gkrpc.server;

import com.smgeek.gkrpc.Request;
import com.smgeek.gkrpc.RequestHandler;
import com.smgeek.gkrpc.Response;
import com.smgeek.gkrpc.TransportServer;
import com.smgeek.gkrpc.codec.Decoder;
import com.smgeek.gkrpc.codec.Encoder;
import com.smgeek.gkrpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 14:25
 * @Description: com.smgeek.gkrpc.server
 * @version: 1.0
 */
@Slf4j
public class RpcServer{
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer() {
        //默认配置
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config){
        this.config = config;
        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.handler);
        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();

    }
    public <T> void register(Class<T> interfaceClass,T bean){
        serviceManager.register(interfaceClass,bean);
    }

    public void start(){
        this.net.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream recive, OutputStream toResp) {
            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(recive,recive.available());
                Request request = decoder.decode(inBytes,Request.class);
                log.info("get request:{}",request);
                ServiceInstance sis = serviceManager.lookup(request);
                Object obj = serviceInvoker.invoke(sis,request);
                resp.setData(obj);
            } catch (Exception e) {
                log.warn(e.getMessage(),e);
                resp.setCode(1);//失败
                resp.setMessage("RpcServer got error:"+e.getClass().getName()+" : "+e.getMessage());
            }finally {
                byte[] outBytes = encoder.encode(resp);
                try {
                    toResp.write(outBytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                }
            }
        }
    };
}
