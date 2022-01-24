package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * in
 */
@SpringBootTest
public class UserMapperInTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void in() {
        // SELECT COUNT( * ) FROM user WHERE (id IN (1,2,3))
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().in(User::getId, 1L, 2L, 3L));

        Assertions.assertEquals(3L, userCount);
    }

    @Test
    public void inWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().in(false, User::getId, 1L, 2L, 3L));

        Assertions.assertEquals(5L, userCount);
    }

}