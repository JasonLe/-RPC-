package com.wanghanle.myrpc.Version1.service;


import com.wanghanle.myrpc.Version1.pojo.Book;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 0:03
 */
public interface BookService {
    Book getbookById(Integer id);
}
