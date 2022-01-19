package com.mawen.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

/**
 * 代码生成器
 *
 * @author mawen
 * @create 2022-01-19 14:25
 */
public class H2Generator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MYSQL", "sa", "");

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


        // 初始化
        before();

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

    /**
     * 执行初始化数据库脚本
     */
    public static void before() throws SQLException {
        Connection conn = DATA_SOURCE_CONFIG.build().getConn();
        InputStream inputStream = H2Generator.class.getResourceAsStream("/db/schema-h2.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }
}
