package com.gdufs.finalexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * BlogLink 实体类用于表示博客的外部链接信息。
 * 包括链接的 ID、类型、名称、URL、描述、排名等信息。
 */
@Data
public class BlogLink {
    private Integer linkId;  // 外部链接的唯一标识 ID
    private Byte linkType;  // 链接类型，通常用于标识链接的性质或分类
    private String linkName;  // 链接的名称，用于显示或描述链接
    private String linkUrl;  // 链接的 URL 地址
    private String linkDescription;  // 链接的简短描述，用于说明链接内容
    private Integer linkRank;  // 链接的排名，通常用于排序链接的优先级
    private Byte isDeleted;  // 链接是否已删除，1 为已删除，0 为未删除

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;  // 链接的创建时间，使用 JsonFormat 注解进行时间格式化

    /**
     * 设置链接名称，若传入为 null，则设置为空。
     *
     * @param linkName 链接名称
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    /**
     * 设置链接 URL，若传入为 null，则设置为空。
     *
     * @param linkUrl 链接的 URL 地址
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * 设置链接描述，若传入为 null，则设置为空。
     *
     * @param linkDescription 链接描述
     */
    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription == null ? null : linkDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", linkId=").append(linkId);
        sb.append(", linkType=").append(linkType);
        sb.append(", linkName=").append(linkName);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkDescription=").append(linkDescription);
        sb.append(", linkRank=").append(linkRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}
