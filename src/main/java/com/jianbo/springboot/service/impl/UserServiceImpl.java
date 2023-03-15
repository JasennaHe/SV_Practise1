package com.jianbo.springboot.service.impl;

import com.jianbo.springboot.entity.User;
import com.jianbo.springboot.mapper.UserMapper;
import com.jianbo.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JianboHe
 * @since 2023-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
