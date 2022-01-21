package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.mawen.mybatisplus.entity.User;
import com.mawen.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserServiceChainTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 如果指定的字段和对象的字段数量不符，且该对象中没有无参构造器，那么就会报错：java.lang.IndexOutOfBoundsException
     * 解决方案：在对象中添加无参构造器
     * @see {@link https://github.com/baomidou/mybatis-plus/issues/2775}
     */
    @Test
    public void query() {
        // without condition
        List<User> list = userService.query().select("id", "name", "age", "email")
                .list(); // SELECT id,name,age,email FROM user
        list.forEach(System.out::println);

        // with condition
        List<User> users = userService.query().select("id", "name", "age")
                .ge("id", 2L)
                .list(); // SELECT id,name,age,email FROM user WHERE (id >= 2)
        users.forEach(System.out::println);

        // one
        User user = userService.query().eq("id", 1L).one();
        System.out.println(user);
    }

    @Test
    public void lambdaQuery() {
        // without condition
        List<User> list = userService.lambdaQuery().select(User::getId, User::getName, User::getAge)
                .list(); // SELECT id,name,age FROM user
        list.forEach(System.out::println);

        // with condition
        List<User> userList = userService.lambdaQuery().select(User::getId, User::getName, User::getAge)
                .ge(User::getId, 3L)
                .list(); // SELECT id,name,age FROM user
        userList.forEach(System.out::println);

        // one
        User one = userService.lambdaQuery().eq(User::getId, 1L).one();
        System.out.println(one);
    }

    @Test
    public void update() {
        User one = userService.lambdaQuery().eq(User::getId, 1L).one();
        one.setName(UUID.randomUUID().toString());

        boolean b = userService.update().eq("id", one.getId()).update(one);
        System.out.println("update user ret: " + b);

        User ret = userService.lambdaQuery().eq(User::getId, 1L).one();
        Assertions.assertEquals(one.getName(), ret.getName());
    }

    @Test
    public void lambdaUpdate() {
        String uuidName = UUID.randomUUID().toString();
        User user = userService.lambdaQuery().eq(User::getId, 1L).one();
        user.setName(uuidName);
        boolean b = userService.lambdaUpdate().ge(User::getId, 1L).update(user);
        System.out.println("update user ret:" + b);

        User ret = userService.lambdaQuery().eq(User::getId, 1L).one();
        Assertions.assertEquals(user.getName(), ret.getName());
    }
}