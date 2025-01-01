package com.gdufs.finalexam.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.util.StringUtils;
import java.util.Arrays;

/**
 * @description Markdown 工具类
 * 该类提供了将 Markdown 格式的文本转换为 HTML 格式的功能，适用于处理包含 Markdown 格式文本的内容。
 */
public class MarkDownUtil {

    /**
     * 将 Markdown 格式的文本转换为 HTML 格式。
     * 该方法利用 CommonMark 库来解析和渲染 Markdown 格式内容，支持基本的 Markdown 语法和表格扩展。
     *
     * @param markdownString Markdown 格式的输入字符串
     * @return 返回转换后的 HTML 格式字符串，若输入为空，则返回空字符串
     */
    public static String mdToHtml(String markdownString) {
        // 如果输入的 Markdown 字符串为空，直接返回空字符串
        if (!StringUtils.hasText(markdownString)) {
            return "";
        }

        // 使用 CommonMark 库扩展来解析 Markdown 文本，支持表格语法
        java.util.List<Extension> extensions = Arrays.asList(TablesExtension.create());

        // 创建 Markdown 解析器，加入扩展
        Parser parser = Parser.builder().extensions(extensions).build();

        // 解析 Markdown 文本为一个节点树
        Node document = parser.parse(markdownString);

        // 创建 HTML 渲染器，将节点树转换为 HTML
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();

        // 返回转换后的 HTML 格式内容
        return renderer.render(document);
    }
}
