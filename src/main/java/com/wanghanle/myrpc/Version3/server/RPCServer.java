package com.wanghanle.myrpc.Version3.server;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 22:27
 */
public interface RPCServer {
    void start(int port);
    void stop();
}
