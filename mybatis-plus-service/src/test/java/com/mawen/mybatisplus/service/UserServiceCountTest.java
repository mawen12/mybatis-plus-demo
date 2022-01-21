package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class UserServiceCountTest {

    @Autowired
    private UserService userService;

    @Test
    public void count() {
        long count = userService.count();// SELECT COUNT( * ) FROM user
        Assertions.assertEquals(5, count);
    }

    @Test
    public void countWithWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().ge(User::getId, 1L);
        long count = userService.count(queryWrapper); // SELECT COUNT( * ) FROM user WHERE (id >= 1)
        Assertions.assertEquals(5, count);
    }

}