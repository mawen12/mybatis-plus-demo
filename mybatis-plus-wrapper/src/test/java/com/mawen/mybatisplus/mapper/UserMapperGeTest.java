package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ge(great than and equals) == >=
 */
@SpringBootTest
public class UserMapperGeTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void ge() {
        // SELECT COUNT( * ) FROM user WHERE (id >= 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().ge(User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

    @Test
    public void geWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().ge(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}