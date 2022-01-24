package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * groupBy = group by
 */
@SpringBootTest
public class UserMapperGroupByTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void groupBy() {
        // SELECT id,name,email,age FROM user GROUP BY email
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().groupBy(User::getEmail));

        Assertions.assertEquals(5L, userList.size());
    }

    @Test
    public void eqWithCondition() {
        // SELECT COUNT( * ) FROM user
        Long userCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().groupBy(false, User::getEmail));

        Assertions.assertEquals(5L, userCount);
    }

}