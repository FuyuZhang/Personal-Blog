package com.gdufs.finalexam;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description 个人博客应用的启动类
 * 该类是 Spring Boot 应用的入口，负责启动应用并配置一些必要的设置。
 */
@Slf4j // 使用 Lombok 提供的日志功能
@MapperScan("com.gdufs.finalexam.dao") // 扫描指定包中的 MyBatis 映射接口
@SpringBootApplication // 启动 Spring Boot 应用
public class PersonalBlogApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(PersonalBlogApplication.class, args);

        // 打印日志，显示应用启动成功并输出相关访问信息
        log.info("运行成功");
        log.info("前台登录http://localhost:8080/");
        log.info("后台登录http://localhost:8080/admin/login");
        log.info("管理员账号admin密码123456");
    }

}
