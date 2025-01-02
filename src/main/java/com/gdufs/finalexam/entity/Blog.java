package com.gdufs.finalexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Blog实体类表示博客（Blog）的实体，包含博客的基本信息及相关操作。
 * 该类主要用于系统中博客的存储、显示和管理功能。
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long blogId;  // 博客的唯一标识 ID
    private String blogTitle;  // 博客的标题
    private String blogSubUrl;  // 博客的子 URL，用于访问博客的链接
    private String blogCoverImage;  // 博客封面图像的路径或 URL
    private Integer blogCategoryId;  // 博客所属类别的 ID
    private String blogCategoryName;  // 博客所属类别的名称
    private String blogTags;  // 博客的标签，多个标签用逗号分隔
    private Byte blogStatus;  // 博客的状态，通常用于标识博客是否可见或已发布
    private Long blogViews;  // 博客的访问量或阅读次数
    private Byte enableComment;  // 是否允许评论，1 为允许，0 为不允许
    private Byte isDeleted;  // 博客是否已删除，1 为已删除，0 为未删除

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;  // 博客的创建时间，使用 JsonFormat 注解进行时间格式化

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;  // 博客的更新时间

    private String blogContent;  // 博客的内容，通常是文章的正文部分


    //构造方法
    public Blog() {
    }

    public Blog(Long blogId, String blogTitle, String blogSubUrl, String blogCoverImage, Integer blogCategoryId, String blogCategoryName, String blogTags, Byte blogStatus, Long blogViews, Byte enableComment, Byte isDeleted, Date createTime, Date updateTime, String blogContent) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogSubUrl = blogSubUrl;
        this.blogCoverImage = blogCoverImage;
        this.blogCategoryId = blogCategoryId;
        this.blogCategoryName = blogCategoryName;
        this.blogTags = blogTags;
        this.blogStatus = blogStatus;
        this.blogViews = blogViews;
        this.enableComment = enableComment;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.blogContent = blogContent;
    }

    // Getter 和 Setter 方法
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
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogSubUrl() {
        return blogSubUrl;
    }

    public void setBlogSubUrl(String blogSubUrl) {
        this.blogSubUrl = blogSubUrl == null ? null : blogSubUrl.trim();
    }

    public String getBlogCoverImage() {
        return blogCoverImage;
    }

    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage == null ? null : blogCoverImage.trim();
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName == null ? null : blogCategoryName.trim();
    }

    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags == null ? null : blogTags.trim();
    }

    public Byte getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Byte blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }

    public Byte getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Byte enableComment) {
        this.enableComment = enableComment;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }


    /**
     * 重写 toString 方法，输出 Blog 对象的详细信息
     *
     * @return Blog 对象的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogId=").append(blogId);
        sb.append(", blogTitle=").append(blogTitle);
        sb.append(", blogSubUrl=").append(blogSubUrl);
        sb.append(", blogCoverImage=").append(blogCoverImage);
        sb.append(", blogCategoryId=").append(blogCategoryId);
        sb.append(", blogCategoryName=").append(blogCategoryName);
        sb.append(", blogTags=").append(blogTags);
        sb.append(", blogStatus=").append(blogStatus);
        sb.append(", blogViews=").append(blogViews);
        sb.append(", enableComment=").append(enableComment);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", blogContent=").append(blogContent);
        sb.append("]");
        return sb.toString();
    }
}
