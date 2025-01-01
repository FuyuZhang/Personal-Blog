package com.gdufs.finalexam.config;

/**
 * @Description 项目常量配置类
 * 该类用于存储项目中的全局常量配置，便于集中管理和访问。
 * 常量包括文件上传路径及模板主题名等。
 */
public class Constants {

    /**
     * 文件上传的默认路径前缀。
     * 根据项目部署位置需要自行修改，确保路径有效且有写入权限。
     * 目前设置为本地桌面的 "uploadblog" 文件夹。
     */
    public static final String FILE_UPLOAD_DIC = "C:/Users/fuyuzhang/Desktop/uploadblog/";

    /**
     * 模板主题1的名称。
     * 默认主题，用于展示基础样式。
     */
    public static final String THEME1 = "default";

    /**
     * 模板主题2的名称。
     * "yummy-jekyll" 是一种风格更活泼的主题，可用于展示个性化博客。
     */
    public static final String THEME2 = "yummy-jekyll";

    /**
     * 模板主题3的名称。
     * "amaze" 主题适用于更现代化、简洁的界面风格。
     */
    public static final String THEME3 = "amaze";
}
