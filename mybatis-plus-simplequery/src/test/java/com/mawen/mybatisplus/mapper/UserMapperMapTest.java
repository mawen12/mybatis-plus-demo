package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class UserMapperMapTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void map() {
        Map<Long, String> idNameMap = SimpleQuery.map(Wrappers.lambdaQuery(), User::getId, User::getName);
        printMap(idNameMap);
    }

    @Test
    public void mapWithPeeks() {
        // TODO
    }

    private void printMap(Map map) {
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}