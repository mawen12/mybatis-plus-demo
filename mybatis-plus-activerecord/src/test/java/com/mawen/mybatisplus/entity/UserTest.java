package com.mawen.mybatisplus.entity;

import com.mawen.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserTest {

    @Test
    public void crud() {
        User user = new User();
        user.setName(UUID.randomUUID().toString());
        user.setEmail("1111@qq.com");
        user.setAge(10);
        Assertions.assertTrue(user.insert()); // INSERT INTO user ( id, age, name, email ) VALUES ( 1484707821690617858, 10, '51d33a78-5b7c-4c4a-9780-f031c6c27e6c', '1111@qq.com' )

        User ret = user.selectById(); // SELECT id,age,name,email FROM user WHERE id=1484707821690617858
        Assertions.assertNotNull(ret);
        Assertions.assertEquals(user.getName(), ret.getName());
        Assertions.assertEquals(user.getEmail(), ret.getEmail());
        Assertions.assertEquals(user.getAge(), ret.getAge());

        user.setName(UUID.randomUUID().toString());
        user.setAge(10);
        Assertions.assertTrue(user.insertOrUpdate()); //

        Assertions.assertTrue(user.deleteById()); //

        List<User> userList = user.selectAll();
        Assertions.assertEquals(5, userList.size());
    }
}