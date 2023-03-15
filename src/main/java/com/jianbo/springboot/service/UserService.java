package com.jianbo.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jianbo.springboot.entity.User;
import com.jianbo.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public boolean saveUser(User user) {
        boolean save = saveOrUpdate(user); // saveOrUpdate（mybatis-plus提供的方法，表示插入或更新数据）
        return save;
    }
//    @Autowired
//    private UserMapper userMapper;
//    public int save(User user){
//        if(user.getId() == null){
//            return userMapper.insert(user);
//        }else {
//            return userMapper.update(user);
//        }
//    }
}
