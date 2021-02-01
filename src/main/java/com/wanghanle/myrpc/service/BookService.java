package com.wanghanle.myrpc.service;


import com.wanghanle.myrpc.pojo.Book;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 0:03
 */
public interface BookService {
    Book getbookById(Integer id);
}
