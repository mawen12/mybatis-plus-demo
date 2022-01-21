package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author mawen
 * @create 2022-01-21 11:46
 */
@MybatisPlusTest
public class UserMapperDeleteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void delete() {
        Long count = userMapper.selectCount(null);

        int i = userMapper.delete(new QueryWrapper<User>().lambda().eq(User::getId, 1L));
        System.out.println("delete user ret: " + i);

        Long ret = userMapper.selectCount(null);
        Assertions.assertEquals(count - i, ret);
    }

    @Test
    public void deleteBatchIds() {
        List<User> userList = userMapper.selectList(null);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());

        int i = userMapper.deleteBatchIds(ids);
        System.out.println("delete ids ret:" + i);

        Long ret = userMapper.selectCount(null);
        Assertions.assertEquals(0, ret);
    }

    @Test
    public void deleteById() {
        int i = userMapper.deleteById(1L);
        System.out.println("delete id ret:" + i);

        User user = userMapper.selectById(1L);
        Assertions.assertNull(user);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> paramMap = Maps.newHashMap("id", 1L);
        int i = userMapper.deleteByMap(paramMap);
        System.out.println("delete map ret:" + i);

        User user = userMapper.selectById(1L);
        Assertions.assertNull(user);
    }
}
