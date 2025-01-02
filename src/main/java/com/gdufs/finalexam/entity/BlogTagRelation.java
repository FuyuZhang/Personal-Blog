package com.gdufs.finalexam.entity;

import lombok.Data;
import java.util.Date;

/**
 * BlogTagRelation 实体类用于表示博客和标签之间的关联关系。
 * 每个博客可以关联多个标签，这个类通过 blogId 和 tagId 来记录这种关系。
 */
@Data
public class BlogTagRelation {
    private Long relationId;  // 关联关系的唯一标识 ID
    private Long blogId;  // 博客的 ID，表示该博客与标签的关联
    private Integer tagId;  // 标签的 ID，表示与该博客相关联的标签
    private Date createTime;  // 关联关系的创建时间


    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", relationId=").append(relationId);
        sb.append(", blogId=").append(blogId);
        sb.append(", tagId=").append(tagId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}
