package com.mawen.mybatisplus.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通用Mapper，扩展BaseMapper
 *
 * @author mawen
 * @create 2022-01-21 22:03
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 根据 ID 更新固定的那几个字段(但是不包含逻辑删除)
     * @see com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById
     * @param entity
     * @return
     */
    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

    /**
     * 删除所有数据
     * @see com.mawen.mybatisplus.methods.DeleteAll 方法名要和DeleteAll类中定义的一致，就确保了反射能够调用成功
     * @return
     */
    int deleteAll();

    /**
     * 批量新增数据,自选字段 insert
     * @see InsertBatchSomeColumn
     * @param entityList
     * @return
     */
    int insertBatchSomeColumn(List<T> entityList);

    int insertIgnore(T entity);
}
