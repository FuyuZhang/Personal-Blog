package com.gdufs.finalexam.utils;

import org.springframework.util.StringUtils;
import java.net.URI;

/**
 * @description 博客相关的工具类
 * 该类提供了一些与博客处理相关的功能，包括获取 URI 的主机部分和清洗字符串等操作。
 */
public class MyBlogUtil {

    /**
     * 获取 URI 的主机部分（不包括路径、查询参数等）
     *
     * @param uri 输入的 URI 对象
     * @return 返回 URI 的主机部分（如：域名），如果输入 URI 格式不正确，则返回 null
     */
    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(),
                    uri.getUserInfo(),
                    uri.getHost(),
                    uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }

    /**
     * 清洗字符串，避免潜在的恶意代码注入
     * 该方法会对输入字符串进行一系列替换，防止常见的跨站脚本（XSS）攻击和SQL注入攻击
     *
     * @param value 输入的字符串
     * @return 返回经过清洗后的字符串，所有可能的恶意代码都将被替换为无害字符
     */
    public static String cleanString(String value) {
        if (!StringUtils.hasText(value)) {
            return "";
        }
        value = value.toLowerCase();
        // 替换HTML特殊字符，避免XSS攻击
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        // 替换括号，防止JavaScript注入
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        // 替换单引号，防止SQL注入
        value = value.replaceAll("'", "& #39;");
        // 替换常见的JavaScript函数名及关键词
        value = value.replaceAll("onload", "0nl0ad");
        value = value.replaceAll("xml", "xm1");
        value = value.replaceAll("window", "wind0w");
        value = value.replaceAll("click", "cl1ck");
        value = value.replaceAll("var", "v0r");
        value = value.replaceAll("let", "1et");
        value = value.replaceAll("function", "functi0n");
        value = value.replaceAll("return", "retu1n");
        // 清除 JavaScript 事件处理函数
        value = value.replaceAll("$", "");
        value = value.replaceAll("document", "d0cument");
        value = value.replaceAll("const", "c0nst");
        // 去除 eval 函数中的内容
        value = value.replaceAll("eval\\((.*)\\)", "");
        // 清除通过 JavaScript 注入的恶意链接
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        // 替换 script 标签名，避免 XSS 脚本攻击
        value = value.replaceAll("script", "scr1pt");
        // 替换数据库相关的关键字，防止 SQL 注入
        value = value.replaceAll("insert", "1nsert");
        value = value.replaceAll("drop", "dr0p");
        value = value.replaceAll("create", "cre0ate");
        value = value.replaceAll("update", "upd0ate");
        value = value.replaceAll("alter", "a1ter");
        value = value.replaceAll("from", "fr0m");
        value = value.replaceAll("where", "wh1re");
        value = value.replaceAll("database", "data1base");
        value = value.replaceAll("table", "tab1e");
        value = value.replaceAll("tb", "tb0");
        return value;
    }
}
