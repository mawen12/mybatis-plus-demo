package com.mawen.mybatisplus.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 用户
 *
 * @author mawen
 * @create 2022-01-19 17:32
 */
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
