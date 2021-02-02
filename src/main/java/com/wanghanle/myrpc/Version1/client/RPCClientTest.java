package com.wanghanle.myrpc.Version1.client;

import com.wanghanle.myrpc.Version1.pojo.Blog;
import com.wanghanle.myrpc.Version1.pojo.Book;
import com.wanghanle.myrpc.Version1.pojo.User;
import com.wanghanle.myrpc.Version1.service.BlogService;
import com.wanghanle.myrpc.Version1.service.BookService;
import com.wanghanle.myrpc.Version1.service.UserService;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 18:25
 */
public class RPCClientTest {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8888);
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 服务的方法1
        User userById = proxy.getUserByUserId(10);
        System.out.println("从服务端获得的user：" + userById);

        // 服务的方法2
        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据：" + integer);

        // 客户中添加新的测试用例
        BlogService blogService = clientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);

        // 客户中添加新的测试用例
        BookService bookService = clientProxy.getProxy(BookService.class);
        Book book = bookService.getbookById(10000);
        System.out.println("从服务端得到的book为：" + book);
    }
}
