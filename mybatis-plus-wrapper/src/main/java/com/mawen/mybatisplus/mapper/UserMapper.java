package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mawen.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper
 *
 * @author mawen
 * @create 2022-01-24 9:54
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
