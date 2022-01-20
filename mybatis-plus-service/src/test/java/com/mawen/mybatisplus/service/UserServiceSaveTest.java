package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserServiceSaveTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveOne() {
        User user = User.builder().name("mawen").age(10).email("test6@baomidou.com").build();
        boolean ret = userService.save(user);
        System.out.println("save one ret: " + ret);

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getId, user.getId());
        User result = userService.getOne(userQueryWrapper);

        Assertions.assertEquals(result.getName(), user.getName());
        Assertions.assertEquals(result.getAge(), user.getAge());
        Assertions.assertEquals(result.getEmail(), user.getEmail());

    }

    @Test
    public void saveBatch() {
        User user1 = User.builder().name("mawen1").age(20).email("test7@baomidou.com").build();
        User user2 = User.builder().name("mawen2").age(30).email("test8@baomidou.com").build();
        List<User> users = Lists.newArrayList(user1, user2);

        boolean b = userService.saveBatch(users);
        System.out.println("save batch ret: " + b + System.currentTimeMillis());
    }

    @Test
    public void saveBatchWithSize() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            userList.add(User.builder().name("mawen"+i).age(i).email("test7@baomidou.com").build());
        }

        boolean b = userService.saveBatch(userList, userList.size());
        System.out.println("save batch ret: " + b + System.currentTimeMillis());

        long count = userService.count();
        Assertions.assertEquals(count, userList.size() + 5);
    }

    /**
     * 如果记录ID值为空，或者指定ID值在数据库中不存在，就保存；否则会进行更新
     */
    @Test
    public void saveOrUpdate() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getId, 1);
        User user = userService.getOne(userQueryWrapper);
        Assertions.assertNotNull(user);

        user.setName(UUID.randomUUID().toString());
        boolean b = userService.saveOrUpdate(user);
        System.out.println("save or update ret: " + b);

        User result = userService.getOne(userQueryWrapper);
        Assertions.assertEquals(result.getName(), user.getName());
    }

    @Test
    public void saveOrUpdateWithWrapper() {
        User user = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getId, 1));
        user.setName("jack");

        LambdaUpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>().lambda().isNull(true, User::getName).eq(User::getId, user.getId());
        boolean b = userService.saveOrUpdate(user, userUpdateWrapper);
        System.out.println("save or update ret: " + b);
    }

    @Test
    public void saveOrUpdateBatch() {
        List<User> users = userService.list(new QueryWrapper<User>().lambda().ge(User::getId, 1));
        users.forEach(user -> user.setName(user.getName() + "i"));

        User lose = User.builder().name("lose").age(10).email("111@text.com").build();
        users.add(lose);

        userService.saveOrUpdateBatch(users);

        User ret = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getName, lose.getName()));
        Assertions.assertEquals(lose.getName(), ret.getName());
        Assertions.assertEquals(lose.getAge(), ret.getAge());
        Assertions.assertEquals(lose.getEmail(), ret.getEmail());
    }

}