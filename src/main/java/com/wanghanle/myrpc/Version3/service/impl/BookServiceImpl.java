package com.wanghanle.myrpc.Version3.service.impl;

import com.wanghanle.myrpc.Version3.pojo.Book;
import com.wanghanle.myrpc.Version3.service.BookService;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 23:59
 */
public class BookServiceImpl implements BookService {

    @Override
    public Book getbookById(Integer id) {
        Book book = Book.builder().id(1).bookName("深入理解JVM虚拟机").build();
        System.out.println("客户端查询了第"+id+"本书籍");
        return book;
    }


}
