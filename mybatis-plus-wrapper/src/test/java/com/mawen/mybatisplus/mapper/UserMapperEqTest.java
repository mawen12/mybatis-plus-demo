package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * inSql（in (SQL子句)） == in
 */
@SpringBootTest
public class UserMapperEqTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void eq() {
        // SELECT COUNT( * ) FROM user WHERE (id = 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getId, 1L));

        Assertions.assertEquals(1L, userCount);
    }

    @Test
    public void eqWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}