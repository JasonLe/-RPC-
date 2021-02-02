package com.wanghanle.myrpc.Version3.service.impl;

import com.wanghanle.myrpc.Version3.pojo.User;
import com.wanghanle.myrpc.Version3.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 18:18
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了"+id+"的用户");
        // 模拟从数据库中取用户的行为,设置一个随机id
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;
    }

    @Override
    public Integer insertUserId(User user) {
        System.out.println("插入数据成功："+user);
        return 1;
    }
}
