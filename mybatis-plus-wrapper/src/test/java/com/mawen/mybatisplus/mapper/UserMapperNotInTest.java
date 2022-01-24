package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * notIn(Not in) == not in
 */
@SpringBootTest
public class UserMapperNotInTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void notIN() {
        // SELECT COUNT( * ) FROM user WHERE (id NOT IN (1,2,3))
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notIn(User::getId, 1L, 2L, 3L));

        Assertions.assertEquals(2L, userCount);
    }

    @Test
    public void notInWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notIn(false, User::getId, 1L, 2L, 3L));

        Assertions.assertEquals(5L, userCount);
    }

}