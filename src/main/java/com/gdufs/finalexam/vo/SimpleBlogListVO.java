package com.gdufs.finalexam.vo;

import lombok.Data;
import java.io.Serializable;

/**
 * @description 简单的博客列表视图对象（VO）
 * 用于展示博客的简化信息
 */
@Data
public class SimpleBlogListVO implements Serializable {

    // 博客的ID
    private Long blogId;

    // 博客的标题
    private String blogTitle;
}
