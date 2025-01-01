package com.gdufs.finalexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * BlogTag 实体类用于表示博客标签的信息。
 * 包括标签的 ID、名称、删除状态和创建时间等信息。
 */
@Data
public class BlogTag {
    private Integer tagId;  // 标签的唯一标识 ID
    private String tagName;  // 标签的名称，用于标识或描述标签
    private Byte isDeleted;  // 标签是否已删除，1 为已删除，0 为未删除

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;  // 标签的创建时间，使用 JsonFormat 注解进行时间格式化

    /**
     * 设置标签名称，若传入为 null，则设置为空。
     *
     * @param tagName 标签名称
     */
    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tagName=").append(tagName);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}
