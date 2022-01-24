package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ne(not equals) == !=
 */
@SpringBootTest
public class UserMapperNeTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void ne() {
        // SELECT COUNT( * ) FROM user WHERE (id <> 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().ne(User::getId, 1L));

        Assertions.assertEquals(4L, userCount);
    }

    @Test
    public void neWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().ne(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}