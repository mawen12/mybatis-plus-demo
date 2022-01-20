package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.enhe.core.tool.utils.BeanUtil;
import com.mawen.mybatisplus.entity.User;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.function.Function;

@SpringBootTest
public class UserServiceGetTest {

    @Autowired
    private UserService userService;

    @Test
    public void getById() {
        User user = userService.getById(1L);
        System.out.println("id=1L user: " + user);
        Assertions.assertNotNull(user);
    }

    @Test
    public void getOne() {
        User user = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getId, 1L));
        System.out.println("id=1L user: " + user);
        Assertions.assertNotNull(user);
    }

    @Test
    public void getOneWithoutEx() {
        User user = userService.getOne(new QueryWrapper<User>().lambda().ge(User::getId, 1L), false);
        System.out.println("id=1L user: " + user);
        Assertions.assertNotNull(user);
    }

    @Test
    public void getMap() {
        Map<String, Object> map = userService.getMap(new QueryWrapper<User>().lambda().eq(User::getId, 1L));
        System.out.println("id=1L user: " + map);
        Assertions.assertNotNull(map);
    }

    @Test
    public void getObj() {
        // Nothing
    }

}