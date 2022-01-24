package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserMapperListTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询表内记录，封装返回为List<属性>
     */
    @Test
    public void list() {
        List<Long> ids = SimpleQuery.list(Wrappers.lambdaQuery(), User::getId);
        Assertions.assertTrue(ids.size() == 5);
    }

    /**
     * 查询表内记录，封装返回为List<属性>，考虑了并行流的情况
     */
    @Test
    public void listWithPeeks() {
        List<String> names = SimpleQuery.list(Wrappers.lambdaQuery(), User::getName, e -> Optional.ofNullable(e.getName()).map(String::toUpperCase).ifPresent(e::setName));
        names.forEach(System.out::println);
    }
}