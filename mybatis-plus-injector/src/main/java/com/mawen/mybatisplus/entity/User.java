package com.mawen.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @author mawen
 * @create 2022-01-21 21:23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(
            value = "id",
            type = IdType.ASSIGN_ID
    )
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
