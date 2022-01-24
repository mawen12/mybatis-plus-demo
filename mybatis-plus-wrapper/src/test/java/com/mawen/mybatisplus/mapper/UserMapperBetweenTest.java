package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * between ==  between and
 */
@SpringBootTest
public class UserMapperBetweenTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void between() {
        // SELECT COUNT( * ) FROM user WHERE (id BETWEEN 1 AND 2)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().between(User::getId, 1L, 2L));

        Assertions.assertEquals(2L, userCount);
    }

    @Test
    public void betweenWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().between(false, User::getId, 1L, 2L));

        Assertions.assertEquals(5L, userCount);
    }

}