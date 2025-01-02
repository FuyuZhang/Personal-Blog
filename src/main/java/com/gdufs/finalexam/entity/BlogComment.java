package com.gdufs.finalexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * BlogComment 实体类用于表示博客评论的信息。
 * 包括评论的唯一标识、评论内容、评论者信息、评论时间、是否已删除等信息。
 */
@Data
public class BlogComment {
    private Long commentId;  // 评论的唯一标识 ID
    private Long blogId;  // 关联的博客 ID，表示评论属于哪篇博客
    private String commentator;  // 评论者的名称
    private String email;  // 评论者的邮箱地址
    private String websiteUrl;  // 评论者的个人网站 URL
    private String commentBody;  // 评论的正文内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentCreateTime;  // 评论的创建时间，使用 JsonFormat 注解进行时间格式化

    private String commentatorIp;  // 评论者的 IP 地址
    private String replyBody;  // 博主或管理员对评论的回复内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replyCreateTime;  // 回复的创建时间，使用 JsonFormat 注解进行时间格式化

    private Byte commentStatus;  // 评论的状态，标识评论是否通过审核，1 为已通过，0 为未通过
    private Byte isDeleted;  // 评论是否已删除，1 为已删除，0 为未删除

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator == null ? null : commentator.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl == null ? null : websiteUrl.trim();
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null ? null : commentBody.trim();
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public String getCommentatorIp() {
        return commentatorIp;
    }

    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp == null ? null : commentatorIp.trim();
    }

    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody == null ? null : replyBody.trim();
    }

    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", blogId=").append(blogId);
        sb.append(", commentator=").append(commentator);
        sb.append(", email=").append(email);
        sb.append(", websiteUrl=").append(websiteUrl);
        sb.append(", commentBody=").append(commentBody);
        sb.append(", commentCreateTime=").append(commentCreateTime);
        sb.append(", commentatorIp=").append(commentatorIp);
        sb.append(", replyBody=").append(replyBody);
        sb.append(", replyCreateTime=").append(replyCreateTime);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}