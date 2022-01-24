package com.mawen.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @author mawen
 * @create 2022-01-22 9:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User extends Model<User> {
    private Long id;
    private Integer age;
    private String name;
    private String email;
}
