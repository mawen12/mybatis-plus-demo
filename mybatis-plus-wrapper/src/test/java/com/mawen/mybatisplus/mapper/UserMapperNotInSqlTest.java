package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * notInSql(not in (SQL子句)) ==  not in
 */
@SpringBootTest
public class UserMapperNotInSqlTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void notInSql() {
        // SELECT COUNT( * ) FROM user WHERE (id NOT IN ())
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notInSql(User::getId, "SELECT id FROM user WHERE id = 3"));

        Assertions.assertEquals(4L, userCount);
    }

    @Test
    public void notInSqlWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().notInSql(false, User::getId, "SELECT id FROM user WHERE id = 3"));

        Assertions.assertEquals(5L, userCount);
    }

}