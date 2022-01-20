package com.mawen.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mawen.mybatisplus.mapper")
public class MPBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MPBaseApplication.class, args);
	}

}
