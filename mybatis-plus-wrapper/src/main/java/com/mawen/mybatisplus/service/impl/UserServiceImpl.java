package com.mawen.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mawen.mybatisplus.entity.User;
import com.mawen.mybatisplus.mapper.UserMapper;
import com.mawen.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author mawen
 * @create 2022-01-25 11:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
