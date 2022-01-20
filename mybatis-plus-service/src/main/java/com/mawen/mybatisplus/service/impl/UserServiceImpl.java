package com.mawen.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mawen.mybatisplus.entity.User;
import com.mawen.mybatisplus.mapper.UserMapper;
import com.mawen.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author mawen
 * @create 2022-01-19 17:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
