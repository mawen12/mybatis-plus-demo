package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * notLike == not like %%
 */
@SpringBootTest
public class UserMapperNotLikeTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void notLike() {
        // SELECT COUNT( * ) FROM user WHERE (email not LIKE '%baomidou.com%')
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notLike(User::getEmail, "baomidou.com"));

        Assertions.assertEquals(0L, userCount);
    }

    @Test
    public void notLikeWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notLike(false, User::getEmail, "baomidou.com"));

        Assertions.assertEquals(5L, userCount);
    }

}