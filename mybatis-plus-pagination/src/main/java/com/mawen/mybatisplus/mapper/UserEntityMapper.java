package com.mawen.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mawen.mybatisplus.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户Mapper
 *
 * @author mawen
 * @create 2022-01-25 14:03
 */
@Repository
public interface UserEntityMapper {

    IPage<UserEntity> selectPageVo(Page<?> page, @Param("state") Integer state);

}
