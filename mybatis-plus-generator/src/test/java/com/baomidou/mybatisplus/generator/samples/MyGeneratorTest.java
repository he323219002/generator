package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                builder.parent("com.jframe.basic") // 设置父包名
//                    .moduleName("acc") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\code\\generator\\generate-code\\mapper")); // 设置mapperXml生成路径
                builder.enumerate("domain.acc.enumerate");
                builder.entity("acc.gatewayimpl.database.dataobject");
                builder.mapper("acc.gatewayimpl.database.mapper");
                builder.mapstruct("acc.convetor");
                builder.domainEntity("domain.acc.entity");
                builder.dto("acc.dto.data");
            })
            .strategyConfig(builder -> {
                builder.addInclude("acc_account") // 设置需要生成的表名
                    .addTablePrefix("acc_", "c_")
                    .entityBuilder().formatFileName("%sDbo")
                    .enableFileOverride()
                    .serviceBuilder()
                    .formatServiceFileName("%sService")
                    .mapstructBuilder()
                    .enableFileOverride()
                    .dtoBuilder()
                    .enableFileOverride()
                    .domainEntityBuilder()
                    .enableFileOverride()
                    .entityBuilder()
                    .logicDeletePropertyName("deleted")
                    .versionPropertyName("version")
                    .addTableFills(List.of(new Column("create_time", FieldFill.INSERT)
                        , new Column("create_user_id", FieldFill.INSERT)
                        , new Column("update_time", FieldFill.INSERT_UPDATE)
                        , new Column("update_user_id", FieldFill.INSERT_UPDATE)))
//                    .addTableFills(new Column("create_time", FieldFill.INSERT)) // 自动填充配置
//                    .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))

                    // TableField注解
                    .enableTableFieldAnnotation()
                    .superClass("com.jframe.base.Dbo")
                    .enableFileOverride()
                ; // 设置过滤表前缀

            })
            .templateConfig(builder -> {
//             禁用模板类型
//                builder.disable(TemplateType.ENUMERATE);
                builder.mapstruct();
                builder.dto();
                builder.domainEntity();
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();

    }

}
