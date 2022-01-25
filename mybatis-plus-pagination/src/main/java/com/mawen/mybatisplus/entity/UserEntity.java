package com.mawen.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @author mawen
 * @create 2022-01-25 14:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer state;
}
