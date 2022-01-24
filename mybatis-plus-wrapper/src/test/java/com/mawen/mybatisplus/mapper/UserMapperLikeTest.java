package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * like == like %%
 */
@SpringBootTest
public class UserMapperLikeTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void like() {
        // SELECT COUNT( * ) FROM user WHERE (email LIKE '%baomidou.com%')
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().like(User::getEmail, "baomidou.com"));

        Assertions.assertEquals(5L, userCount);
    }

    @Test
    public void likeWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().like(false, User::getEmail, "baomidou.com"));

        Assertions.assertEquals(5L, userCount);
    }

}