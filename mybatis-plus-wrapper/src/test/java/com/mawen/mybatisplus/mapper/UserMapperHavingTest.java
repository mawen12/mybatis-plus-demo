package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Ordering;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * orderBy == order by
 */
@SpringBootTest
public class UserMapperHavingTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void orderBy() {
        // SELECT * FROM user ORDER BY id DESC
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByDesc(User::getId, User::getAge));

        Assertions.assertEquals(5L, userList.size());
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        Assertions.assertTrue(Ordering.natural().reverse().isOrdered(ids));
    }

    @Test
    public void orderByWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().orderBy(false, true, User::getId));

        Assertions.assertEquals(5L, userCount);
    }

}