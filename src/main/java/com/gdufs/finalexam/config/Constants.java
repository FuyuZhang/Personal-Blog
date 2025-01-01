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
     * 模板主题
     */
    public static final String THEME = "amaze";
}
