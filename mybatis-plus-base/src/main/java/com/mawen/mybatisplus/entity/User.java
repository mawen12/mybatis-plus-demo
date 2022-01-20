package com.mawen.mybatisplus.entity;

import lombok.Data;

/**
 * 用户类
 *
 * @author mawen
 * @create 2022-01-19 15:46
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

