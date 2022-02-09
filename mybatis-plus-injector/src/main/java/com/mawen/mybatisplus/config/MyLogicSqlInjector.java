package com.mawen.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.mawen.mybatisplus.methods.DeleteAll;
import com.mawen.mybatisplus.methods.InsertIgnore;

import java.util.List;

/**
 * 自定义SqlInjector，其中包含了所有的自定义全局方法
 *
 * @author mawen
 * @create 2022-01-21 22:23
 */
public class MyLogicSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new DeleteAll());
        // https://github.com/baomidou/mybatis-plus/blob/747cc828088bcc4e34308c83377fe7b2ddd9654f/mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/mysql/config/MybatisPlusConfig.java
        methodList.add(new AlwaysUpdateSomeColumnById(t -> !t.isLogicDelete() && !t.isVersion() && t.getFieldFill() != FieldFill.INSERT));
        methodList.add(new InsertBatchSomeColumn(t -> !t.isLogicDelete() && !t.isVersion() && t.getFieldFill() != FieldFill.UPDATE));
        methodList.add(new DeleteById());
        methodList.add(new InsertIgnore());
        return methodList;
    }
}
