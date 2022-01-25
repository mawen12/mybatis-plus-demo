package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * func = if {} else {}
 * @author mawen
 * @create 2022-01-25 9:34
 */
@SpringBootTest
public class UserMapperFuncTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void func() {
        // SELECT id,name,email,age FROM user WHERE (id = 1)
        boolean needCondition = true;
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().func(needCondition, i -> i.eq(User::getId, 1L)));

        Assertions.assertEquals(1, userList.size());
    }

    @Test
    public void funcWithCondition() {
        // SELECT * FROM user
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().func(false, i -> i.eq(User::getId, 1L)));

        Assertions.assertEquals(5, userList.size());
    }

}
