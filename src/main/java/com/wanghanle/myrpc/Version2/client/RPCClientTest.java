package com.wanghanle.myrpc.Version2.client;

import com.wanghanle.myrpc.Version2.pojo.Blog;
import com.wanghanle.myrpc.Version2.pojo.Book;
import com.wanghanle.myrpc.Version2.pojo.User;
import com.wanghanle.myrpc.Version2.service.BlogService;
import com.wanghanle.myrpc.Version2.service.BookService;
import com.wanghanle.myrpc.Version2.service.UserService;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 18:25
 */
public class RPCClientTest {
    public static void main(String[] args) {
        // 传统BIO方式
        // 构建一个使用java Socket传输的客户端
        SimpleRPCClient simpleRPCClient = new SimpleRPCClient("127.0.0.1", 8888);
        // 把这个客户端传入代理客户端
        RPCClientProxy rpcClientProxy = new RPCClientProxy(simpleRPCClient);
        // 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
        UserService userService = rpcClientProxy.getProxy(UserService.class);
        // 调用方法
        User userByUserId = userService.getUserByUserId(10);

        BookService bookService = rpcClientProxy.getProxy(BookService.class);
        Book bookByBook = bookService.getbookById(200);
    }
}
