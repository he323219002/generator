package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @Author: Jimmy He
 * @Date: 2023/4/19 22:39
 * @Description: TODO 描述
 */
public class MyGeneratorTest extends BaseGeneratorTest {

    @Test
    public void testGenerate() {

        System.out.println("中文");
        FastAutoGenerator.create("jdbc:mysql://192.168.195.150:3306/jframe", "root", "home")
            .globalConfig(builder -> {
                builder.author("jimmy") // 设置作者
//                    .enableSwagger() // 开启 swagger 模式
                    .disableOpenDir()
                    .outputDir("D:\\code\\generator\\generate-code"); // 指定输出目录
            })

            .packageConfig(builder -> {
                builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                    .moduleName("system") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\code\\generator\\generate-code\\mapper")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.addInclude("acc_account") // 设置需要生成的表名
                    .addTablePrefix("acc_", "c_")
                    .entityBuilder().formatFileName("%sDbo")
                    .enableFileOverride()
                    .serviceBuilder()
                    .formatServiceFileName("%sService")
                    .mapstructBuilder()
                    .enableFileOverride();
                ; // 设置过滤表前缀
            })
            .templateConfig(builder -> {
//             禁用模板类型
//                builder.disable(TemplateType.ENUMERATE);
                builder.mapstruct();
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }


//    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/eladmin?characterEncoding=UTF-8&useUnicode=true&useSSL=false", "root", "abc123")
//            // 全局配置
//            .globalConfig(builder -> {
//                builder.author("wanggc") // 设置作者
//                    .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
//                    .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
//                    .disableOpenDir() //禁止打开输出目录，默认打开
//                ;
//            })
//            // 包配置
//            .packageConfig(builder -> {
//                builder.parent("demo.generator") // 设置父包名
//                    .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mappers")); // 设置mapperXml生成路径
//            })
//            // 策略配置
//            .strategyConfig(builder -> {
//                builder.addInclude("sys_menu") // 设置需要生成的表名
//                    .addTablePrefix("sys_") // 设置过滤表前缀
//                    // Entity 策略配置
//                    .entityBuilder()
//                    .enableLombok() //开启 Lombok
//                    .enableFileOverride() // 覆盖已生成文件
//                    .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
//                    .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
//                    // Mapper 策略配置
//                    .mapperBuilder()
//                    .enableFileOverride() // 覆盖已生成文件
//                    // Service 策略配置
//                    .serviceBuilder()
//                    .enableFileOverride() // 覆盖已生成文件
//                    .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
//                    .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
//                    // Controller 策略配置
//                    .controllerBuilder()
//                    .enableFileOverride() // 覆盖已生成文件
//                ;
//            })
//            .execute();
//
//    }
}
