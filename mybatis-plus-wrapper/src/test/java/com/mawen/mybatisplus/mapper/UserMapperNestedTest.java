package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * nested
 * @author mawen
 * @create 2022-01-25 9:56
 */
@SpringBootTest
public class UserMapperNestedTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void nested() {
        // SELECT id,name,email,age FROM user WHERE ((id = 1 AND id = 2))
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().nested(i -> i.eq(User::getId, 1L).eq(User::getId, 2L)));

        Assertions.assertEquals(0, count);
    }

    @Test
    public void nestedWithCondition() {
        // SELECT id,name,email,age FROM user
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().nested(false, i -> i.eq(User::getId, 1L).eq(User::getId, 2L));
        Long count = userMapper.selectCount(queryWrapper);

        Assertions.assertEquals(5, count);
    }


}
