package com.mawen.mybatisplus.methods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.junit.platform.commons.util.StringUtils;

/**
 * 忽略`INSERT`语句中错误行
 *
 * @author mawen
 * @create 2022-02-09 17:19
 */
public class InsertIgnore extends AbstractMethod {

    /**
     * 定义方法名称
     */
    private static final String METHOD_NAME = "insertIgnore";

    public InsertIgnore() {
        super(METHOD_NAME);
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String tableName = tableInfo.getTableName();
        String columnScript = tableInfo.getAllInsertSqlColumnMaybeIf(null);
        String valueScript = tableInfo.getAllInsertSqlPropertyMaybeIf(null);
        String sql = String.format("INSERT IGNORE INTO %s (%s) VALUES (%s)", tableName, columnScript, valueScript);
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);

        KeyGenerator keyGenerator = new NoKeyGenerator();
        String keyProperty = null, keyColumn = null;
        if (StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
            if (tableInfo.getIdType() == IdType.AUTO) {
                keyGenerator = new Jdbc3KeyGenerator();
                keyProperty = tableInfo.getKeyProperty();
                keyColumn = tableInfo.getKeyColumn();
            }
            else if (tableInfo.getKeySequence() != null) {
                keyGenerator = TableInfoHelper.genKeyGenerator(METHOD_NAME, tableInfo, this.builderAssistant);
                keyProperty = tableInfo.getKeyProperty();
                keyColumn = tableInfo.getKeyColumn();
            }
        }

        return this.addInsertMappedStatement(mapperClass, modelClass, METHOD_NAME, sqlSource, keyGenerator, keyProperty, keyColumn);
    }
}
