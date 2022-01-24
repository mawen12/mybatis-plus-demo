package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * eq(equals) ==  =
 */
@SpringBootTest
public class UserMapperInSqlTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void inSql() {
        // SELECT COUNT( * ) FROM user WHERE (id IN (SELECT id FROM user WHERE id = 3))
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().inSql(User::getId, "SELECT id FROM user WHERE id = 3"));

        Assertions.assertEquals(1L, userCount);
    }

    @Test
    public void inSqlWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().inSql(false, User::getId, "SELECT id FROM user WHERE name = 3"));

        Assertions.assertEquals(5L, userCount);
    }

}