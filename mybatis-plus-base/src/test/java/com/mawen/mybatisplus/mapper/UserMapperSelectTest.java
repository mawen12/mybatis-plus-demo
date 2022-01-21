package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
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
import java.util.stream.Collectors;

/**
 * @author mawen
 * @create 2022-01-21 11:46
 */
@SpringBootTest
public class UserMapperSelectTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        User user = userMapper.selectById(1L);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(1L, user.getId());
    }

    @Test
    public void selectOne() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getId, 1L);
        User user = userMapper.selectOne(queryWrapper);
        Assertions.assertNotNull(user);
    }

    @Test
    public void selectBatchIds() {
        List<Long> ids = Lists.newArrayList(1L, 2L, 3L, 4L, 5L);
        List<User> userList = userMapper.selectBatchIds(ids);
        userList.forEach(System.out::println);

        Assertions.assertEquals(ids.size(), userList.size());
    }

    @Test
    public void selectList() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().ge(User::getId, 1L);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

        Assertions.assertEquals(5, userList.size());
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = Maps.newHashMap("id", 1L);
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);

        Assertions.assertEquals(1, userList.size());
    }

    @Test
    public void selectMaps() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getId, 1L);
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        list.forEach(System.out::println);

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void selectObjs() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getId, 1L);
        List<Object> objs = userMapper.selectObjs(queryWrapper);
        objs.forEach(System.out::println);

        Assertions.assertEquals(1, objs.size());
    }

    @Test
    public void selectPage() {
        Page<User> page = Page.of(1, 2);
        Wrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().ge(User::getId, 1L);
        userMapper.selectPage(page, queryWrapper);

        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                page.getCurrent(), // 当前页，从1开始
                page.getPages(),  // 总页数
                page.getSize(),  // 每页显示记录数
                page.getTotal(),  // 总记录数
                page.getRecords()); // 记录列表
    }

    @Test
    public void selectMapsPage() {
        Page page = Page.of(1, 2);
        Wrapper<User> wrapper = Wrappers.<User>lambdaQuery().ge(User::getId, 1L);
        userMapper.selectMapsPage(page, wrapper);

        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                page.getCurrent(), // 当前页，从1开始
                page.getPages(),  // 总页数
                page.getSize(),  // 每页显示记录数
                page.getTotal(),  // 总记录数
                page.getRecords()); // 记录列表
    }

    @Test
    public void selectCount() {
        Wrapper<User> wrapper = Wrappers.<User>lambdaQuery().eq(User::getId, 1L);
        Long count = userMapper.selectCount(wrapper); // SELECT COUNT( * ) FROM user WHERE (id = 1)
        System.out.println("user count: " + count);

        Assertions.assertEquals(1L, count);
    }

}
