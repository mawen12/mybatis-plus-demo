package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * orderByDesc == order by desc
 */
@SpringBootTest
public class UserMapperOrderByDescTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void orderByDesc() {
        // SELECT * FROM user ORDER BY id DESC
        List<Long> ids = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByDesc(User::getId)).stream().map(User::getId).collect(Collectors.toList());

        Assertions.assertEquals(5L, ids.size());
        Assertions.assertTrue(Ordering.natural().reverse().isOrdered(ids));

    }

    @Test
    public void orderByDescWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().orderByDesc(false, User::getId));

        Assertions.assertEquals(5L, userCount);
    }

}