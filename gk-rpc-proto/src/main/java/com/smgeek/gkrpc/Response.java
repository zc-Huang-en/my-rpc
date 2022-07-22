package com.smgeek.gkrpc;

import lombok.Data;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 9:54
 * @Description: RPC的返回
 * @version: 1.0
 */
@Data
public class Response{
    /*
     * 服务返回编码 0成功，非0就失败
     */
    private int code = 0;
    /*
     * 具体错误信息
     */
    private String message = "ok";
    /*
     * 返回数据
     */
    private Object data;
}
