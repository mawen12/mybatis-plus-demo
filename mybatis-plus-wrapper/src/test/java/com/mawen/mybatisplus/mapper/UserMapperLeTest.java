package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * le(less than and equals) == <=
 */
@SpringBootTest
public class UserMapperLeTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void le() {
        // SELECT COUNT( * ) FROM user WHERE (id <= 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().le(User::getId, 1L));

        Assertions.assertEquals(1L, userCount);
    }

    @Test
    public void leWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().le(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}