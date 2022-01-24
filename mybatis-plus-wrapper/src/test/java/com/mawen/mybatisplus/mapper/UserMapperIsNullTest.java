package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * isNull ==  is null
 */
@SpringBootTest
public class UserMapperIsNullTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void isNull() {
        // SELECT COUNT( * ) FROM user WHERE (id IS NULL)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().isNull(User::getId));

        Assertions.assertEquals(0L, userCount);
    }

    @Test
    public void isNullWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().isNull(false, User::getId));

        Assertions.assertEquals(5L, userCount);
    }

}