package com.wanghanle.myrpc.service.impl;

import com.wanghanle.myrpc.pojo.Blog;
import com.wanghanle.myrpc.service.BlogService;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 22:12
 */
public class BlogServiceImpl implements BlogService {

    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(1).title("这是一篇博客").useId(22).build();
        System.out.println("客户端查询了"+id+"博客");
        return blog;
    }
}
