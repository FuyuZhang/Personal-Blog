# 个人博客系统

## 概述
这个是一个基于JAVA的期末项目。

## 使用环境及相关依赖：
Java 版本：Java 17。
整体通过 Maven 进行项目构建与管理

### 主要依赖：
spring-boot-starter-web 用于构建 Web 应用。
spring-boot-starter-test 用于测试（测试范围）。
spring-tx 处理事务相关功能。
mybatis-spring-boot-starter 及 mybatis-spring 用于 MyBatis 与 Spring Boot 整合操作数据库。
mysql-connector-j （运行时范围）用于连接 MySQL 数据库。
lombok 简化代码编写（通过注解等方式）。
commonmark 及其拓展用于相关文本处理。
springdoc-openapi-starter-webmvc-ui 用于接口文档相关功能。
hibernate-validator 及 spring-boot-starter-validation 进行数据验证。
spring-boot-starter-thymeleaf 实现页面模板渲染。
