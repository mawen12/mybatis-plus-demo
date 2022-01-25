package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * apply  拼接SQL，请使用动态入参的方式，这样不会有SQL注入的风险
 * MP会进行优化，例如自动添加 and
 * @author mawen
 * @create 2022-01-25 10:08
 */
@SpringBootTest
public class UserMapperApplyTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void apply() {
        // SELECT id,name,email,age FROM user WHERE (id = 1 AND id = 2)
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getId, 1L).apply("id = {0}", 2));

        Assertions.assertEquals(0, count);
    }

    @Test
    public void applyWithCondition() {
        // SELECT id,name,email,age FROM user WHERE (id = 1)
        Long count = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getId, 1L).apply(false, "id = {0}", 2));

        Assertions.assertEquals(1, count);
    }

}
