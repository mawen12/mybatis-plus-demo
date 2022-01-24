package com.mawen.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户
 * @author mawen
 * @create 2022-01-22 10:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -7383268344784187879L;
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
