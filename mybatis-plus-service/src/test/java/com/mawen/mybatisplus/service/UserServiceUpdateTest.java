package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserServiceUpdateTest {

    @Autowired
    private UserService userService;

    /**
     * @see {@link https://github.com/baomidou/mybatis-plus/blob/ed6d8a80e93b0d2070d95e1fda5b07fd874d1a71/mybatis-plus-core/src/test/java/com/baomidou/mybatisplus/core/conditions/UpdateWrapperTest.java}
     */
    @Test
    public void update() {
        String randomName = UUID.randomUUID().toString();
        boolean b = userService.update(new UpdateWrapper<User>()
                .set("name", randomName)
                        .set("age", 20)
                .last("WHERE id = 1"));
        System.out.println("update id=1 ret: " + b);

        User ret = userService.getById(1L);
        Assertions.assertEquals(randomName, ret.getName());
        Assertions.assertEquals(20, ret.getAge());
    }

    @Test
    public void updateWithWrapper() {
        User user = userService.getById(1L);
        user.setName(UUID.randomUUID().toString());
        boolean b = userService.update(user, new UpdateWrapper<User>().lambda().eq(User::getId, user.getId()));
        System.out.println("update id=1 ret: " + b);

        User ret = userService.getById(1L);
        Assertions.assertEquals(user.getName(), ret.getName());
    }

    @Test
    public void updateById() {
        User user = userService.getById(1L);
        user.setName(UUID.randomUUID().toString());
        boolean b = userService.updateById(user);
        System.out.println("update id=1 ret: " + b);

        User ret = userService.getById(user.getId());
        Assertions.assertEquals(user.getName(), ret.getName());
    }

    @Test
    public void updateBatchById() {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda().ge(User::getId, 1L);
        List<User> users = userService.list(queryWrapper);
        users.forEach(user -> user.setName(UUID.randomUUID().toString()));
        boolean b = userService.updateBatchById(users);
        System.out.println("update batchid ret: " + b);

        List<User> rets = userService.list(queryWrapper);

        for (int i = 0; i < rets.size(); i++) {
            Assertions.assertEquals(users.get(0).getName(), rets.get(0).getName());
        }
    }
}