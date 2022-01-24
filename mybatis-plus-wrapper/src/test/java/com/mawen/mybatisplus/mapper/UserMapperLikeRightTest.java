package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * likeRight == like 值%
 */
@SpringBootTest
public class UserMapperLikeRightTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void likeRight() {
        // SELECT COUNT( * ) FROM user WHERE (email LIKE 'baomidou.com%')
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().likeRight(User::getEmail, "baomidou.com"));

        Assertions.assertEquals(0L, userCount);
    }

    @Test
    public void likeRightWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().likeRight(false, User::getEmail, "baomidou.com"));

        Assertions.assertEquals(5L, userCount);
    }

}