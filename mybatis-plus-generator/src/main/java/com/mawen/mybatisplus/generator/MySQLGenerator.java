package com.mawen.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

/**
 * MySQL 数据库代码生成器
 *
 * 引入mysql-connector-java
 *
 * @author mawen
 * @create 2022-01-19 14:25
 */
public class MySQLGenerator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://192.168.190.210:3306/mybatis-plus", "mawen", "mawen123");

    /**
     * 具体代码中暂不支持Mysql
     * @param args
     */
    public static void main(String[] args) throws SQLException, IOException {
        String projectPath = System.getProperty("user.dir") + "\\mybatis-plus-generator";
        String dir = projectPath + "\\src\\main\\java\\";
        String packageName = "com.mawen.mybatisplus";
        String mapperPath = dir + packageName.replaceAll("\\.", "\\\\") + "\\mapper";

        System.out.println("projectPath = " + projectPath);
        System.out.println("dir = " + dir);
        System.out.println("packageName = " + packageName);
        System.out.println("mapperPath = " + mapperPath);
        System.out.println(System.getProperty("java.class.path"));

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    // 设置作者名
                    builder.author("mawen")
                            .enableSwagger()
                            .fileOverride()
                            // 指定输出目录
                            .outputDir(dir);
                }).packageConfig(builder -> {
                    // 设置父包名
                    builder.parent(packageName)
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, mapperPath));
                }).strategyConfig(builder -> {
                    builder.addInclude("user")
                            .addFieldPrefix("t_", "c_");
                })
                // 使用FreeMarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
