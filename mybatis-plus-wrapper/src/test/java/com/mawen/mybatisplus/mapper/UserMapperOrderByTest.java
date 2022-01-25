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
 * having = having sql
 */
@SpringBootTest
public class UserMapperOrderByTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void having() {
        // SELECT * FROM user GROUP BY age HAVING age > 25
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().groupBy(User::getAge).having("age > {0}", 25L));
        Assertions.assertEquals(1L, userList.size());
    }

    @Test
    public void havingWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().groupBy(false, User::getAge).having(false, "age > 25"));

        Assertions.assertEquals(5L, userCount);
    }

}