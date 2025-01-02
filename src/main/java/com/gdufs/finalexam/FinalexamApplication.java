package com.gdufs.finalexam;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description 个人博客应用的启动类
 * 该类是 Spring Boot 应用的入口，负责启动应用并配置一些必要的设置。
 */
@MapperScan("com.gdufs.finalexam.dao") // 扫描指定包中的 MyBatis 映射接口
@SpringBootApplication // 启动 Spring Boot 应用
public class FinalexamApplication {
    //日志对象
    private static final Logger logger = LoggerFactory.getLogger(FinalexamApplication.class);

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(FinalexamApplication.class, args);

        // 打印日志，显示应用启动成功并输出相关访问信息
        logger.info("运行成功");
        logger.info("前台登录http://localhost:8080/");
        logger.info("后台登录http://localhost:8080/admin/login");
        logger.info("管理员账号admin密码123456");
    }

}
