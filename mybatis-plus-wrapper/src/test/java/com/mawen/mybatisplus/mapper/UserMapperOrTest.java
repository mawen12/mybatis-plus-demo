package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * or
 * @author mawen
 * @create 2022-01-25 9:46
 */
@SpringBootTest
public class UserMapperOrTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void or() {
        // SELECT id,name,email,age FROM user WHERE (id = 1 OR id = 2)
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getId, 1L).or().eq(User::getId, 2L));

        Assertions.assertEquals(2, userList.size());
    }

    @Test
    public void orWithCondition() {
        // SELECT id,name,email,age FROM user WHERE (id = 1 AND id = 2)
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getId, 1L).or(false).eq(User::getId, 2L));

        Assertions.assertEquals(0, userList.size());
    }



}
