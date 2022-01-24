package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * isNotNull == IS NOT NULL
 */
@SpringBootTest
public class UserMapperIsNotNullTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void isNotNull() {
        // SELECT COUNT( * ) FROM user WHERE (id = 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().isNotNull(User::getId));

        Assertions.assertEquals(5L, userCount);
    }

    @Test
    public void isNotNullWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().isNotNull(false, User::getId));

        Assertions.assertEquals(5L, userCount);
    }

}