package com.wanghanle.myrpc.service;

import com.wanghanle.myrpc.pojo.Blog;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 22:12
 */
public interface BlogService {
    Blog getBlogById(Integer id);
}
