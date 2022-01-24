package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class UserMapperKeyMapTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void keyMap() {
        Map<String, User> nameUserMap = SimpleQuery.keyMap(Wrappers.lambdaQuery(), User::getName);
        printMap(nameUserMap);
    }

    @Test
    public void keyMapWithPeeks() {
        // key -> name，这个Name的值是大写的
        Map<String, User> nameUserMap = SimpleQuery.keyMap(Wrappers.lambdaQuery(), User::getName, e -> Optional.ofNullable(e.getName()).map(String::toUpperCase).ifPresent(e::setName));
        printMap(nameUserMap);
    }

    private void printMap(Map<String, User> map) {
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}