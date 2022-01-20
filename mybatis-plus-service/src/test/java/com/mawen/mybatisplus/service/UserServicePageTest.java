package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.enhe.core.tool.api.R;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServicePageTest {

    @Autowired
    private UserService userService;

    /**
     * IPage<T> page(IPage<T>) 参数和返回结果是同一个对象。
     */
    @Test
    public void page() {
        Page<User> page = new Page<>(1, 2);
        Page<User> ret = userService.page(page);
        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                ret.getCurrent(), // 当前页，从1开始
                ret.getPages(),  // 总页数
                ret.getSize(),  // 每页显示记录数
                ret.getTotal(),  // 总记录数
                ret.getRecords()); // 记录列表

        Assertions.assertEquals(page.getRecords().size(), ret.getTotal());


    }

}