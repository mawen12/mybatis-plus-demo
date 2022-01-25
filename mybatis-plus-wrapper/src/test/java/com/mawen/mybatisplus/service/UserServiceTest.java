package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import com.mawen.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void set() {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId, 1L));
        user.setName(UUID.randomUUID().toString());
        // UPDATE user SET name = '' WHERE id = 1L
        userService.lambdaUpdate().set(User::getName, user.getName()).eq(User::getId, 1L).update();

        User ret = userMapper.selectById(1L);
        Assertions.assertEquals(user.getName(), ret.getName());
    }

}