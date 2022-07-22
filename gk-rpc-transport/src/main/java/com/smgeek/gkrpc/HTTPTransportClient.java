package com.smgeek.gkrpc;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 11:06
 * @Description: 将数据封装进行request请求再进行发送
 * @version: 1.0
 */
public class HTTPTransportClient implements TransportClient {
    private String url;

    @Override
    public void connect(Peer peer) {
        this.url = "http://"+peer.getHost()+":"+peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConn = (HttpURLConnection)new URL(url).openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");
            httpConn.connect();
            //把数据拷贝到outputStream里面去
            IOUtils.copy(data,httpConn.getOutputStream());
            int resultCode = httpConn.getResponseCode();
            if(resultCode == HttpURLConnection.HTTP_OK){
                return httpConn.getInputStream();
            }else {
                return httpConn.getErrorStream();
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
