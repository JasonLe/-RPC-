package com.wanghanle.myrpc.Version2.server;

import com.wanghanle.myrpc.Version2.service.BlogService;
import com.wanghanle.myrpc.Version2.service.UserService;
import com.wanghanle.myrpc.Version2.service.impl.BlogServiceImpl;
import com.wanghanle.myrpc.Version2.service.impl.UserServiceImpl;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 16:49
 */
public class TestNettyServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8888);
    }
}
