package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * lt(less than) == <
 */
@SpringBootTest
public class UserMapperLtTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void lt() {
        // SELECT COUNT( * ) FROM user WHERE (id < 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().lt(User::getId, 1L));

        Assertions.assertEquals(0L, userCount);
    }

    @Test
    public void ltWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().lt(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}