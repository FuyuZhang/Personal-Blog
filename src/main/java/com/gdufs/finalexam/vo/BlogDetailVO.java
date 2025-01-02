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

    // 博客的标题xq
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

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getBlogCategoryIcon() {
        return blogCategoryIcon;
    }

    public void setBlogCategoryIcon(String blogCategoryIcon) {
        this.blogCategoryIcon = blogCategoryIcon;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getBlogCoverImage() {
        return blogCoverImage;
    }

    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }

    public List<String> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<String> blogTags) {
        this.blogTags = blogTags;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Byte getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Byte enableComment) {
        this.enableComment = enableComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
