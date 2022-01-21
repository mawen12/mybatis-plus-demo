package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author mawen
 * @create 2022-01-21 11:46
 */
@MybatisPlusTest
public class UserMapperUpdateTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void update() {
        User user = userMapper.selectById(1L);
        user.setName(UUID.randomUUID().toString());

        int i = userMapper.update(user, Wrappers.<User>lambdaUpdate().eq(User::getId, user.getId()));
        System.out.println("update user ret: " + i);

        User ret = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId, 1L));

        Assertions.assertEquals(user.getName(), ret.getName());
    }

    @Test
    public void updateById() {
        User user = userMapper.selectById(1L);
        user.setName(UUID.randomUUID().toString());
        int i = userMapper.updateById(user);
        System.out.println("update user ret: " + i);

        User ret = userMapper.selectById(user.getId());
        Assertions.assertEquals(user.getName(), ret.getName());
    }
}
