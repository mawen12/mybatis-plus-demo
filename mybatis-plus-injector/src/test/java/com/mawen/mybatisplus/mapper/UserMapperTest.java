package com.mawen.mybatisplus.mapper;

import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 自定义全局方法 deleteAll
     */
    @Test
    public void deleteAll() {
        Long count = userMapper.selectCount(null);
        Assertions.assertTrue(count > 0);

        int i = userMapper.deleteAll();
        System.out.println("delete ret is: " + i);

        // 验证数据已经删除
        Assertions.assertEquals(0, userMapper.selectCount(null));
    }
}