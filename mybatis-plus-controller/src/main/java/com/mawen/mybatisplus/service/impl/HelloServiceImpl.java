package com.mawen.mybatisplus.service.impl;

import com.mawen.mybatisplus.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author mawen
 * @create 2022-01-21 0:23
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
