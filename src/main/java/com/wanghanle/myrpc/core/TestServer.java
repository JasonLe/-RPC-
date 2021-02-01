package com.wanghanle.myrpc.core;

import com.wanghanle.myrpc.service.BlogService;
import com.wanghanle.myrpc.service.BookService;
import com.wanghanle.myrpc.service.UserService;
import com.wanghanle.myrpc.service.impl.BlogServiceImpl;
import com.wanghanle.myrpc.service.impl.BookServiceImpl;
import com.wanghanle.myrpc.service.impl.UserServiceImpl;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 22:18
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        BookService bookService = new BookServiceImpl();
//        Map<String, Object> serviceProvide = new HashMap<>();
//        // 暴露两个服务接口， 即在RPCServer中加一个HashMap
//        serviceProvide.put("com.wanghanle.myrpc.service.impl",userService);
//        serviceProvide.put("com.wanghanle.myrpc.service.impl",blogService);

        ServiceProvider serviceProvide = new ServiceProvider();
        serviceProvide.provideServiceInterface(userService);
        serviceProvide.provideServiceInterface(blogService);
        serviceProvide.provideServiceInterface(bookService);

        RPCServer RPCServer = new ThreadPoolRPCRPCServer(serviceProvide);
        RPCServer.start(8888);
    }
}
