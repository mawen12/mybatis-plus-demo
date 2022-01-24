package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class UserMapperGroupTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询表内记录，封装返回为Map<属性,List<实体>>
     */
    @Test
    public void group() {
        // 构造相同用户名的数据 + data-h2.sql
        User user = new User();
        user.setName("Tom");
        userMapper.insert(user);

        // 对用户名进行分组
        Map<String, List<User>> map = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName);
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }

    @Test
    public void groupWithPeek() {
        // 构造相同用户名的数据 + data-h2.sql
        User user = new User();
        user.setName("Tom");
        userMapper.insert(user);

        // 对用户名进行分组，且将名称转换为大写
        Map<String, List<User>> map = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName, e -> Optional.ofNullable(e.getName()).map(String::toUpperCase).ifPresent(e::setName));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }

    @Test
    public void groupWithParallel() {
        // 构造相同用户名的数据 + data-h2.sql
        User user = new User();
        user.setName("Tom");
        userMapper.insert(user);

        // 对用户名进行分组，且将名称转换为大写
        Map<String, List<User>> map = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName, true, e -> Optional.ofNullable(e.getName()).map(String::toUpperCase).ifPresent(e::setName));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }

    @Test
    public void groupWithCollect() {
        // 构造相同用户名的数据 + data-h2.sql
        User user = new User();
        user.setName("Tom");
        userMapper.insert(user);

        // https://gitee.com/baomidou/mybatis-plus/blob/3.0/mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/toolkit/SimpleQueryTest.java
        // TODO 对用户名进行分组，且将名称转换为大写
    }

    @Test
    public void groupWithCount() {
        // https://gitee.com/baomidou/mybatis-plus/blob/3.0/mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/toolkit/SimpleQueryTest.java
        // TODO 获取用户名的数量
    }
}