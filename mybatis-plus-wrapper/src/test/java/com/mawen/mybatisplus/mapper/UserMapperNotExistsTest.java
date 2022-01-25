package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * not exists
 * @author mawen
 * @create 2022-01-25 10:31
 */
@SpringBootTest
public class UserMapperNotExistsTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void notExists() {
        String existsSql = "SELECT id FROM user WHERE id = {0}";
        // SELECT id,name,email,age FROM user WHERE (NOT EXISTS (SELECT id FROM user WHERE id = 1))
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().notExists(existsSql, 1L));

        Assertions.assertEquals(0, count);
    }

    @Test
    public void notExistsWithCondition() {
        String existsSql = "SELECT id FROM user WHERE id = {0}";
        // SELECT id,name,email,age FROM user
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().notExists(false, existsSql, 1L));

        Assertions.assertEquals(5, count);
    }
}
