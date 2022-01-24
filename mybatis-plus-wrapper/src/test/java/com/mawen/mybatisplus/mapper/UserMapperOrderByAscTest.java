package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * orderByAsc == order by asc
 */
@SpringBootTest
public class UserMapperOrderByAscTest {

    @Autowire
    private UserMapper userMapper;

    @Test
    public void orderByAsc() {
        // SELECT COUNT( * ) FROM user WHERE (id = 1)
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().orderByAsc(User::getId));

        Assertions.assertEquals(1L, userCount);

    }

    @Test
    public void eqWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(false, User::getId, 1L));

        Assertions.assertEquals(5L, userCount);
    }

}