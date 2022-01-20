package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootTest
public class UserServiceRemoveTest {

    @Autowired
    private UserService userService;

    @Test
    public void remove() {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda().eq(User::getId, 1);
        boolean b = userService.remove(queryWrapper);
        System.out.println("remove id=1 ret: " + b);

        User ret = userService.getOne(queryWrapper);
        Assertions.assertNull(ret);
    }

    @Test
    public void removeById() {
        boolean b = userService.removeById(1L);
        System.out.println("remove id=1 ret: " + b);

        User ret = userService.getById(1L);
        Assertions.assertNull(ret);
    }

    @Test
    public void removeByMap() {
        Map<String, Object> map = Maps.newHashMap("id", 1L);
        boolean b = userService.removeByMap(map);
        System.out.println("remove id=1 ret: " + b);

        User ret = userService.getById(1L);
        Assertions.assertNull(ret);
    }

    @Test
    public void removeByIds() {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda().ge(User::getId, 1L);
        List<User> list = userService.list(queryWrapper);

        List<Long> ids = list.stream().map(User::getId).collect(Collectors.toList());
        boolean b = userService.removeByIds(ids);
        System.out.println("remove id=1 ret: " + b);

        List<User> ret = userService.list(queryWrapper);
        Assertions.assertTrue(ret.isEmpty());
    }
}