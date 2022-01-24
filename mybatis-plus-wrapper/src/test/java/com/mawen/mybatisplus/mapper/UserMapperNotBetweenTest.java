package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * notBetween ==  not between and
 */
@SpringBootTest
public class UserMapperNotBetweenTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void notBetween() {
        // SELECT COUNT( * ) FROM user WHERE (id NOT BETWEEN 1 AND 2)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notBetween(User::getId, 1L, 2L));

        Assertions.assertEquals(3L, userCount);
    }

    @Test
    public void notBetweenWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notBetween(false, User::getId, 1L, 2L));

        Assertions.assertEquals(5L, userCount);
    }

}