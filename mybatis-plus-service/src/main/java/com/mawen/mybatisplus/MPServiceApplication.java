package com.mawen.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 * @author mawen
 * @create 2022-01-19 17:30
 */
@SpringBootApplication
@MapperScan("com.mawen.mybatisplus.mapper")
public class MPServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MPServiceApplication.class, args);
    }

}
