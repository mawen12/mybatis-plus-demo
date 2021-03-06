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
 * orderByAsc == order by asc
 */
@SpringBootTest
public class UserMapperOrderByAscTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void orderByAsc() {
        // SELECT * FROM user ORDER BY id ASC
        List<Long> ids = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByAsc(User::getId)).stream().map(User::getId).collect(Collectors.toList());

        Assertions.assertEquals(5L, ids.size());
        Assertions.assertTrue(Comparators.isInOrder(ids, Ordering.natural()));

    }

    @Test
    public void orderByAscWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().orderByAsc(false, User::getId));

        Assertions.assertEquals(5L, userCount);
    }

}