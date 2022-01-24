package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.mawen.mybatisplus.entity.Dept;
import com.mawen.mybatisplus.entity.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void alwaysUpdateSomeColumnById() {
        // 插入一条数据
        Dept one = new Dept();
        one.setName("PM");
        one.setCreateTime(new Date());
        one.setUpdateTime(new Date());
        deptMapper.insert(one);
        System.out.println("insert user: " + one);

        // 查询数据
        Dept dept = deptMapper.selectById(one.getId());
        Assertions.assertNotNull(dept);
        Assertions.assertNotNull(dept.getName());

        // 更改名称
        dept.setName(UUID.randomUUID().toString());
        // 此处设置的值不会生效，原因是该字段的fill=FieldFill.INSERT，不满足字段更新条件
        dept.setCreateTime(null);
        dept.setUpdateTime(null);
        int i = deptMapper.alwaysUpdateSomeColumnById(dept);
        Assertions.assertTrue(i > 0);

        // 检索
        Dept ret = deptMapper.selectById(one.getId());
        System.out.println("ret user: " + ret);
        Assertions.assertEquals(dept.getName(), ret.getName());
    }

    /**
     * @see TableField#update()
     */
    @Test
    public void tableFieldUpdate() {
        Dept dept = new Dept();
        dept.setName(UUID.randomUUID().toString());
//        dept.setCurrentTime(new Date());
        Assertions.assertTrue(deptMapper.insert(dept) > 0);
        System.out.println("old dept: " + dept);

        Assertions.assertTrue(deptMapper.updateById(dept) > 0);
        Dept ret = deptMapper.selectById(dept.getId());
        System.out.println("ret dept: " + ret);
    }


    /**
     * @see InsertBatchSomeColumn
     * @see com.mawen.mybatisplus.config.MyLogicSqlInjector#getMethodList(Class, TableInfo)
     */
    @Test
    public void insertBatchSomeColumn() {
        Dept dept = new Dept();
        dept.setName(UUID.randomUUID().toString());
        dept.setCurrentTime(new Date());
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        dept.setFuture(new Date());
        Assertions.assertTrue(deptMapper.insertBatchSomeColumn(Lists.newArrayList(dept)) > 0);

        Dept ret = deptMapper.selectById(dept.getId());
        System.out.println("ret dept: " + ret);

        Assertions.assertEquals(dept.getName(), ret.getName());
        Assertions.assertEquals(dept.getCurrentTime(), ret.getCurrentTime());
        Assertions.assertEquals(dept.getCreateTime(), ret.getCreateTime());
        Assertions.assertEquals(dept.getUpdateTime(), ret.getUpdateTime());
        Assertions.assertNull(ret.getFuture());
    }

    @Test
    public void logicDelete() {
        Dept dept = new Dept();
        dept.setName(UUID.randomUUID().toString());
        dept.setCurrentTime(new Date());
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        dept.setFuture(new Date());
        dept.setIsDeleted(false);
        Assertions.assertTrue(deptMapper.insert(dept) > 0);

        Assertions.assertTrue(deptMapper.deleteById(dept) > 0);

        Dept ret = deptMapper.selectById(dept.getId()); // SELECT id,name,ct AS currentTime,create_time,update_time,future,is_deleted FROM dept WHERE id=1484698583081742337 AND is_deleted=false
        Assertions.assertNull(ret);
    }
}