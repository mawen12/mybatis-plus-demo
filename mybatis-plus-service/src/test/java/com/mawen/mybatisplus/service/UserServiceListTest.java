package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.enhe.core.tool.utils.BeanUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mawen.mybatisplus.entity.User;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@SpringBootTest
public class UserServiceListTest {

    @Autowired
    private UserService userService;

    @Test
    public void list() {
        List<User> list = userService.list();
        System.out.println("total record: " + list.size());
        Assertions.assertNotNull(list);
    }

    @Test
    public void listWithWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda().isNotNull(User::getId);
        List<User> list = userService.list(queryWrapper);
        System.out.println("total record: " + list.size());
        Assertions.assertNotNull(list);
    }

    @Test
    public void listByIds() {
        List<Long> ids = Lists.newArrayList(1L, 2L, 3L);
        List<User> userList = userService.listByIds(ids);
        System.out.println("total record: " + userList);
        Assertions.assertEquals(ids.size(), userList.size());
    }

    @Test
    public void listByMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1L);
        List<User> userList = userService.listByMap(map);
        System.out.println("total record: " + userList);
        Assertions.assertEquals(1, userList.size());
    }

    @Test
    public void listMaps() {
        List<Map<String, Object>> maps = userService.listMaps();
        System.out.println("total record: " + maps);
        Assertions.assertNotNull(maps);
    }

    @Test
    public void listMapsWithWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().ge(User::getId, 1L);
        List<Map<String, Object>> userMaps = userService.listMaps(queryWrapper);
        System.out.println("total record: " + userMaps);
        Assertions.assertEquals(5, userMaps.size());
    }

    @Test
    public void listObjs() {
        // Nothing
    }

    /**
     * listObjs 只会返回id值
     */
    @Test
    public void listObjsWithWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .select(User::getId, User::getName, User::getAge, User::getEmail)
                .ge(User::getId, 1L);
        List<Object> objects = userService.listObjs(queryWrapper);
        System.out.println("total record: " + objects);
        Assertions.assertNotNull(objects);
    }

    @Test
    public void listObjsWithWrapperAndMapper() {
        // Nothing
    }
}