package com.mawen.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.mawen.mybatisplus.config.MyBatisPlusConfig;
import com.mawen.mybatisplus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class UserServicePageTest {

    @Autowired
    private UserService userService;

    /**
     * IPage<T> page(IPage<T>) 参数和返回结果是同一个对象。
     * 如果分页的时候不配置{@link MyBatisPlusConfig#paginationInnerInterceptor()}，那么执行的就是内存分页，就是把所有数据取出来，然后进行
     */
    @Test
    public void page() {
        Page<User> page = Page.of(1, 2, false);
        Page<User> ret = userService.page(page);
        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                ret.getCurrent(), // 当前页，从1开始
                ret.getPages(),  // 总页数
                ret.getSize(),  // 每页显示记录数
                ret.getTotal(),  // 总记录数
                ret.getRecords()); // 记录列表
    }

    @Test
    public void pageWithWrapper() {
        Page<User> page = new Page<>(2, 1);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().ge(User::getId, 1L);
        Page<User> ret = userService.page(page, queryWrapper);
        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                ret.getCurrent(), // 当前页，从1开始
                ret.getPages(),  // 总页数
                ret.getSize(),  // 每页显示记录数
                ret.getTotal(),  // 总记录数
                ret.getRecords()); // 记录列表
    }

    @Test
    public void pageMaps() {
        Page<Map<String, Object>> page = new Page<>(1, 5);
        Page<Map<String, Object>> ret = userService.pageMaps(page);
        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                ret.getCurrent(), // 当前页，从1开始
                ret.getPages(),  // 总页数
                ret.getSize(),  // 每页显示记录数
                ret.getTotal(),  // 总记录数
                ret.getRecords()); // 记录列表
    }

    @Test
    public void pageMapsWithWrapper() {
        Page<Map<String, Object>> page = new Page<>(1, 5);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().ge(User::getId, 1L);
        Page<Map<String, Object>> ret = userService.pageMaps(page, queryWrapper);
        System.out.printf("return ret[ current: %d\n, pages: %d\n, size: %d\n, total: %d\n, %s\n.]",
                ret.getCurrent(), // 当前页，从1开始
                ret.getPages(),  // 总页数
                ret.getSize(),  // 每页显示记录数
                ret.getTotal(),  // 总记录数
                ret.getRecords()); // 记录列表
    }


}