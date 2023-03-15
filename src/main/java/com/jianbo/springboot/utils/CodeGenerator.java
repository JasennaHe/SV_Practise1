package com.jianbo.springboot.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * MyBatis-Play代码生成器
 * JianboHe
 * 2023-03-02 21:39
 */
public class CodeGenerator {
    public static void main(String[] args) {
        generate();
    }

    private static void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2b8", "root", "He-12345")
                .globalConfig(builder -> {
                    builder.author("JianboHe") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\5，技术学习\\Java\\Project1\\springboot\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.jianbo.springboot") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\5，技术学习\\Java\\Project1\\springboot\\src\\main\\java\\com\\jianbo\\springboot\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("sys_", "c_"); // 设置过滤表前缀
                })
                // .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
