package com.smgeek.gkrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 9:47
 * @Description: 表示网络传输的端点(网络传输的地址)
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
