package com.mawen.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动
 *
 * @author mawen
 * @create 2022-01-22 10:16
 */
@SpringBootApplication
@MapperScan("com.mawen.mybatisplus.mapper")
public class SimpleQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleQueryApplication.class, args);
    }
}
