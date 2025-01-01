package com.gdufs.finalexam.vo;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @description 博客详情视图对象（VO）
 * 用于展示博客的详细信息
 */
@Data
public class BlogDetailVO {

    // 博客的ID
    private Long blogId;

    // 博客的标题
    private String blogTitle;

    // 博客所属的类别ID
    private Integer blogCategoryId;

    // 博客的评论数量
    private Integer commentCount;

    // 博客类别的图标
    private String blogCategoryIcon;

    // 博客类别名称
    private String blogCategoryName;

    // 博客封面图片
    private String blogCoverImage;

    // 博客的访问量
    private Long blogViews;

    // 博客的标签列表
    private List<String> blogTags;

    // 博客的内容
    private String blogContent;

    // 是否启用评论（1：启用，0：禁用）
    private Byte enableComment;

    // 博客的创建时间
    private Date createTime;
}
