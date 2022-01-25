package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * and
 *
 * @author mawen
 * @create 2022-01-25 9:50
 */
@SpringBootTest
public class UserMapperAndTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void and() {
        // SELECT id,name,email,age FROM user WHERE ((id = 1) AND (id = 2))
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().and(i -> i.eq(User::getId, 1L)).and(i -> i.eq(User::getId, 2L)));

        Assertions.assertEquals(0, count);
    }

    @Test
    public void andWithCondition() {
        // SELECT id,name,email,age FROM user WHERE ((id = 1))
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().and(i -> i.eq(User::getId, 1L)).and(false, i -> i.eq(User::getId, 2L)));

        Assertions.assertEquals(1, count);
    }

}
