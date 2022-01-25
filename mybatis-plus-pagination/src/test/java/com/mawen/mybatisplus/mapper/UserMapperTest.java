package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mawen.mybatisplus.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserEntityMapper userMapper;

    @Test
    public void page() {
        Page<Object> page = Page.of(1, 2);
        IPage<UserEntity> ret = userMapper.selectPageVo(page, 1);

        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                ret.getCurrent(), // 当前页，从1开始
                ret.getPages(),  // 总页数
                ret.getSize(),  // 每页显示记录数
                ret.getTotal(),  // 总记录数
                ret.getRecords()); // 记录列表

        Assertions.assertEquals(3, ret.getPages());
        Assertions.assertEquals(5, ret.getTotal());
    }

}