package com.wanghanle.myrpc.Version3.service;

import com.wanghanle.myrpc.Version3.pojo.User;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 18:18
 */
public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);

    // 给这个服务增加一个功能
    Integer insertUserId(User user);
}
