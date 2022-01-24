package com.mawen.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 部门
 *
 * @author mawen
 * @create 2022-01-21 22:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dept")
public class Dept {
    private Long id;
    private String name;
    @TableField(value = "ct", update = "now()")
    private Date currentTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    // test InsertBatchSomeColumn
    @TableField(value = "future", fill = FieldFill.UPDATE)
    private Date future;
    @TableField(value = "is_deleted")
    @TableLogic(value = "false", delval = "true")
    private Boolean isDeleted;

    public Boolean isDeleted() {
        return isDeleted;
    }
}
