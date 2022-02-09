package com.mawen.mybatisplus.mapper

import com.mawen.mybatisplus.entity.User
import org.h2.engine.UserBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Subject

@ActiveProfiles("default")
@Subject(User)
@SpringBootTest
class UserMapperSpec extends Specification {

    @Autowired
    private UserMapper userMapper;

    def "测试insertIgnore正常插入返回值==1"(){
        given: "prepare user"
        def user = new User(id: 100, age:100)

        expect: "insertIgnore should return 1"
        userMapper.insertIgnore(user) == 1
    }

    def "测试insertIgnore重复插入返回值==1"() {
        given: "parepare two users"
        def user1 = new User(id: 100, age: 100)
        def user2 = new User(id: 100, age: 100)

        expect: "insertIgnore should return 1"
        userMapper.insertIgnore(user1) == 1
        userMapper.insertIgnore(user2) == 1
    }


}
