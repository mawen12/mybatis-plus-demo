package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * select，只用于QueryWrapper，用于指定查询的字段
 * @author mawen
 * @create 2022-01-25 10:50
 */
@SpringBootTest
public class UserMapperSelectTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        // SELECT id,age FROM user WHERE (id = 1)
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().select(User::getId, User::getAge).eq(User::getId, 1L));

        userList.forEach(System.out::println);
        Assertions.assertEquals(1, userList.size());
    }

    @Test
    public void selectWithStr() {
        // SELECT id,age,email FROM user WHERE (id = 1)
        List<User> userList = userMapper.selectList(Wrappers.<User>query().select("id", "age", "email").eq("id", 1L));

        userList.forEach(System.out::println);
        Assertions.assertEquals(1, userList.size());
    }

}
