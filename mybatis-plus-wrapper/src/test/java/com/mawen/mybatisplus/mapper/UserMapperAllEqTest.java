package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * like == like %%
 */
@SpringBootTest
public class UserMapperAllEqTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void like() {
        Map<SFunction<User, ?>, Object> params = Maps.newHashMap(User::getId, 1L);
        params.put(User::getName, null);
        // SELECT id,name,email,age FROM user WHERE (name IS NULL AND id = 1)
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().allEq(params));

        userList.forEach(System.out::println);
        Assertions.assertEquals(0L, userList.size());
    }

    @Test
    public void allEqWithoutNull2IsNull() {
        Map<SFunction<User, ?>, Object> params = Maps.newHashMap(User::getId, 1L);
        params.put(User::getName, null);

        boolean null2IsNull = false;
        // SELECT id,name,email,age FROM user WHERE (id = 1)
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().allEq(params, null2IsNull));

        userList.forEach(System.out::println);
        Assertions.assertEquals(1L, userList.size());
    }

    @Test
    public void allEqWithCondition() {
        Map<SFunction<User, ?>, Object> params = Maps.newHashMap(User::getId, 1L);
        params.put(User::getName, null);

        boolean condition = !params.isEmpty();
        boolean null2IsNull = false;
        // SELECT id,name,email,age FROM user WHERE (id = 1)
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().allEq(condition, params, null2IsNull));

        userList.forEach(System.out::println);
        Assertions.assertEquals(1L, userList.size());
    }

}