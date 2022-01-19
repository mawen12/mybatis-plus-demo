package com.mawen.mybatisplus.service.impl;

import com.mawen.mybatisplus.entity.User;
import com.mawen.mybatisplus.mapper.UserMapper;
import com.mawen.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mawen
 * @since 2022-01-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
