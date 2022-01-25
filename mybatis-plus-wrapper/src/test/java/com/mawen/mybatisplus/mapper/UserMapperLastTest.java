package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * last，请使用动态入参的方式，这样不会有SQL注入的风险
 * 无视MP的优化规则，多条件拼接是需要声明 AND/OR
 * @author mawen
 * @create 2022-01-25 10:12
 */
@SpringBootTest
public class UserMapperLastTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void last() {
        // SELECT id,name,email,age FROM user WHERE (id = 1) AND id = 3
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getId, 1L).last(" AND id = 2").last("AND id = 3"));

        Assertions.assertEquals(0, count);
    }

    @Test
    public void lasWithCondition() {
        // SELECT id,name,email,age FROM user WHERE (id = 1) AND id =2
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getId, 1L).last("AND id = 2").last(false, "AND id = 3"));

        Assertions.assertEquals(0, count);
    }

}
