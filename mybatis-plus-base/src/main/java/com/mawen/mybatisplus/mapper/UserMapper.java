package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mawen.mybatisplus.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Mapper
 *
 * @author mawen
 * @create 2022-01-19 15:47
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    // 将数据查询逻辑下沉到Mapper层
    default User selectByName(String name) {
        return this.selectOne(Wrappers.<User>lambdaQuery().eq(User::getName, name));
    }

}
