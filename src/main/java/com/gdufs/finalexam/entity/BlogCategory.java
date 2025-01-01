package com.gdufs.finalexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * BlogCategory 实体类用于表示博客分类的信息。
 * 包括分类的唯一标识、名称、图标、排序、删除状态以及创建时间等信息。
 */
@Data
public class BlogCategory {
    private Integer categoryId;  // 分类的唯一标识 ID
    private String categoryName;  // 分类的名称
    private String categoryIcon;  // 分类的图标路径或 URL
    private Integer categoryRank;  // 分类的排序值，通常用于确定分类的显示顺序
    private Byte isDeleted;  // 分类是否已删除，1 为已删除，0 为未删除

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;  // 分类的创建时间，使用 JsonFormat 注解进行时间格式化

    /**
     * 设置分类名称，若传入为 null，则设置为空。
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 设置分类图标，若传入为 null，则设置为空。
     *
     * @param categoryIcon 分类图标路径
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryIcon=").append(categoryIcon);
        sb.append(", categoryRank=").append(categoryRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}