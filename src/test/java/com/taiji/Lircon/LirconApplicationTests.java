package com.taiji.Lircon;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.taiji.Lircon.util.NewGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class LirconApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("欢迎来到java课堂");
	}

	@Test
	public void NewGen(){
		System.out.println("欢迎来到 Code Generator 课堂");
		System.out.println(System.getProperty("user.dir"));
		// System.getProperty("user.dir") => D:\iotPlatform\Lircon

		// 4.创建数据库连接
		FastAutoGenerator.create("jdbc:mysql://localhost:3316/space_time?serverTimezone=GMT%2B8", "root", "root")
				// 5.全局配置
				.globalConfig(builder -> {
					builder.author("cao shunmao") // 设置作者 baomidou 默认值:作者
							.enableSwagger() // 开启 swagger 模式 默认值:false
							//.fileOverride() // 覆盖已生成文件 默认值:false
							.disableOpenDir()//禁止打开输出目录 默认值:true
							.commentDate("yyyy-MM-dd")// 注释日期
							.dateType(DateType.ONLY_DATE)//定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
							.outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录 /opt/baomidou/ 默认值: windows:D:// linux or mac : /tmp
					//System.getProperty("user.dir")为你当前模块的绝对路径
				})
				// 6.包配置
				.packageConfig(builder -> {
					builder.parent("com.xyzy.Lircon") // 父包模块名 默认值:com.baomidou
							.controller("controller")//Controller 包名 默认值:controller
							.entity("entity")//Entity 包名 默认值:entity
							.service("service")//Service 包名 默认值:service
							.mapper("mapper")//Mapper 包名 默认值:mapper
							//.moduleName("educms") // 设置父包模块名 默认值:无
							.pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir")+ "/src/main/resources/mapper")); // 设置mapper.xml存放路径
					//默认存放在mapper的xml下
				})
				// 7.策略配置
				.strategyConfig(builder -> {
					builder.addInclude("model3d_base") // 设置需要生成的表名 可边长参数“user”, “user1”
							.addTablePrefix("tb_", "c_") // 设置过滤表前缀
							.serviceBuilder()//service策略配置
							.formatServiceFileName("%sService")
							.formatServiceImplFileName("%sServiceImpl")
							.entityBuilder()// 实体类策略配置
							.idType(IdType.ASSIGN_ID)//主键策略  雪花算法自动生成的id
							// 自动填充配置
							.addTableFills(new Column("gmt_create", FieldFill.INSERT)) //根据数据库字段名适配
							.addTableFills(new Property("gmtModified", FieldFill.INSERT_UPDATE))//根据生成实体类的属性名适配
							.enableLombok() //开启lombok
							.logicDeleteColumnName("deleted")// 说明逻辑删除是哪个字段
							.enableTableFieldAnnotation()// 属性加上注解说明
							.controllerBuilder() //controller 策略配置
							.formatFileName("%sController")
							.enableRestStyle() // 开启RestController注解
							.mapperBuilder()// mapper策略配置
							.formatMapperFileName("%sMapper")
							.enableMapperAnnotation()//@mapper注解开启
							.formatXmlFileName("%sMapper");
				})
				// 8.指定模板引擎
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();

	}

}
