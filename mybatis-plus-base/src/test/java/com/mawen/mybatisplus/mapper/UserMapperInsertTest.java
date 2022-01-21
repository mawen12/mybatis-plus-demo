package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author mawen
 * @create 2022-01-21 11:46
 */
@MybatisPlusTest
public class UserMapperInsertTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName(UUID.randomUUID().toString());
        user.setAge(11);
        user.setEmail("111@test.com");

        int i = userMapper.insert(user);
        System.out.println("insert user ret: " + i);

        User ret = userMapper.selectById(user.getId());
        Assertions.assertEquals(user.getId(), ret.getId());
        Assertions.assertEquals(user.getName(), ret.getName());
        Assertions.assertEquals(user.getAge(), ret.getAge());
        Assertions.assertEquals(user.getEmail(), ret.getEmail());
    }


}
