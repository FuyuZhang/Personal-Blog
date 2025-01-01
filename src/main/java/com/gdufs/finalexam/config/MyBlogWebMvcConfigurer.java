package com.gdufs.finalexam.config;

import com.gdufs.finalexam.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 自定义 Spring MVC 配置类。
 * 该类主要用于注册拦截器和配置静态资源映射。
 * - 添加登录拦截器，限制后台管理相关路径的访问权限。
 * - 配置静态资源映射，支持文件上传路径的访问。
 */
@Configuration
public class MyBlogWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 注入自定义登录拦截器。
     * 用于拦截需要登录权限的请求。
     */
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 配置拦截器。
     * - 拦截以 "/admin/**" 为前缀的路径，确保后台管理页面的安全性。
     * - 排除登录页面和静态资源路径，使其不受拦截器影响。
     *
     * @param registry 拦截器注册对象
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                // 拦截后台管理路径
                .addPathPatterns("/admin/**")
                // 排除登录页面，避免循环拦截
                .excludePathPatterns("/admin/login")
                // 排除后台静态资源路径
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");
    }

    /**
     * 配置静态资源映射。
     * 将 "/upload/**" 的路径映射到本地文件系统目录，支持访问上传的文件。
     *
     * @param registry 静态资源注册对象
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                // 映射到常量配置中的文件上传目录
                .addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
    }
}
