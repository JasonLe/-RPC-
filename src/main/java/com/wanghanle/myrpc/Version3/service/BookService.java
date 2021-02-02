package com.wanghanle.myrpc.Version3.service;


import com.wanghanle.myrpc.Version3.pojo.Book;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 0:03
 */
public interface BookService {
    Book getbookById(Integer id);
}
