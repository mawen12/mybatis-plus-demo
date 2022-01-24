package com.mawen.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动
 *
 * @author mawen
 * @create 2022-01-24 9:52
 */
@SpringBootApplication
@MapperScan("com.mawen.mybatisplus.mapper")
public class WrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrapperApplication.class, args);
    }

}
