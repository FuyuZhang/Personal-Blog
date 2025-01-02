package com.gdufs.finalexam.entity;

import lombok.Data;

/**
 * BlogTagCount 实体类用于表示每个标签的数量统计。
 * 包括标签的 ID、名称和该标签在博客中出现的次数。
 */
@Data
public class BlogTagCount {
    private Integer tagId;  // 标签的唯一标识 ID
    private String tagName;  // 标签的名称，用于标识或描述标签
    private Integer tagCount;  // 该标签在博客中的出现次数


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }
}
