package com.gdufs.finalexam.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @description 博客列表视图对象（VO）
 * 用于展示博客列表信息
 */
@Data
public class BlogListVO implements Serializable {

    // 博客的ID
    private Long blogId;

    // 博客的标题
    private String blogTitle;

    // 博客的自定义URL（用于访问博客详情页的链接）
    private String blogSubUrl;

    // 博客的封面图
    private String blogCoverImage;

    // 博客所属类别的ID
    private Integer blogCategoryId;

    // 博客类别的图标
    private String blogCategoryIcon;

    // 博客类别的名称
    private String blogCategoryName;

    // 博客的创建时间，日期格式为 "yyyy-MM-dd"
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
}
