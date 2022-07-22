package com.smgeek.gkrpc.client;

import com.smgeek.gkrpc.Peer;
import com.smgeek.gkrpc.TransportClient;
import com.smgeek.gkrpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 14:58
 * @Description: com.smgeek.gkrpc.client
 * @version: 1.0
 */
@Slf4j
public class RandomTransportSelector implements TransportSelector {
    /*
     * @Description: 连接好的clients
     * @return:
     */
    List<TransportClient> clients;

    public RandomTransportSelector(){
        clients = new ArrayList();
    }

    @Override
    public void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz) {
        count = Math.max(count,1);
        for(Peer peer:peers){
            for (int i = 0; i < count; i++) {
                TransportClient client = ReflectionUtils.newInstance(clazz);
                client.connect(peer);//做好连接
                clients.add(client);
            }
            log.info("connect server:{}",peer);
        }
    }

    @Override
    public synchronized TransportClient select() {
        int i = new Random().nextInt(clients.size());
        return clients.remove(i);//从多个路由中选择一个
    }

    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for(TransportClient client:clients){
            client.close();
        }
        clients.clear();//关闭所有连接
    }
}
