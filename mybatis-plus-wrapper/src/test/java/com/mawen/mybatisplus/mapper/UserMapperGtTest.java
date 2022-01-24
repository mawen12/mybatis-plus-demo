package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * gt(great than) == >
 */
@SpringBootTest
public class UserMapperGtTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void gt() {
        // SELECT COUNT( * ) FROM user WHERE (id > 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().gt(User::getId, 1L));

        Assertions.assertEquals(4L, userCount);
    }

    @Test
    public void gtWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().gt(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}