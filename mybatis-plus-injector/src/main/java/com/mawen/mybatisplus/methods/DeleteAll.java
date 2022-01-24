package com.mawen.mybatisplus.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 *  删除全局记录
 *
 *  <p>
 *  自己的通用 mapper 如下使用:
 *  <pre>
 *  int deleteAll();
 *  </pre>
 *  </p>
 *
 * @author mawen
 * @create 2022-01-21 22:14
 */
public class DeleteAll extends AbstractMethod {
    /**
     * 定义方法名称
     */
    private static final String METHOD_NAME = "deleteAll";

    public DeleteAll() {
        super(METHOD_NAME);
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // 定义要执行的SQL
        String sql = "DELETE FROM " + tableInfo.getTableName();
        // 创建SQL源
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, mapperClass);
        // 添加
        return this.addDeleteMappedStatement(mapperClass, sqlSource);
    }
}
