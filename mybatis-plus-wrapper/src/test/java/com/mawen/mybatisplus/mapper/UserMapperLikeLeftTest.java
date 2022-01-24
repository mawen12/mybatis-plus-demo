package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * likeLeft == like %值
 */
@SpringBootTest
public class UserMapperLikeLeftTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void likeLeft() {
        // SELECT COUNT( * ) FROM user WHERE (email LIKE '%baomidou.com')
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().likeLeft(User::getEmail, "baomidou.com"));

        Assertions.assertEquals(5L, userCount);
    }

    @Test
    public void likeLeftWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().likeLeft(false, User::getEmail, "baomidou.com"));

        Assertions.assertEquals(5L, userCount);
    }

}