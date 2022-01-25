package com.mawen.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus配置
 *
 * @author mawen
 * @create 2022-01-25 14:01
 */
@Configuration
public class MPConfig {

    /**
     * 分页配置
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 请注意，此处不要填写多个，否则会出现重复注入，出现 LIMIT ? LIMIT ?的情况
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2)); https://github.com/baomidou/mybatis-plus/issues/3589
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }


}
