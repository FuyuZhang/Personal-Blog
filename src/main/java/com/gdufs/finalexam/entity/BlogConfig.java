package com.gdufs.finalexam.entity;

import lombok.Data;
import java.util.Date;

/**
 * BlogConfig 实体类用于表示博客系统的配置信息。
 * 包括配置名称、配置值、创建时间、更新时间等信息。
 */
@Data
public class BlogConfig {
    private String configName;  // 配置项的名称，用于标识配置的作用
    private String configValue;  // 配置项的值，存储具体的配置信息
    private Date createTime;  // 配置项的创建时间
    private Date updateTime;  // 配置项的最后更新时间

    public String getConfigName() {
        return configName;
    }

    /**
     * 设置配置项的名称，若传入为 null，则设置为空。
     *
     * @param configName 配置项名称
     */
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置配置项的值，若传入为 null，则设置为空。
     *
     * @param configValue 配置项的值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置配置项的创建时间。
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置配置项的更新时间。
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configName=").append(configName);
        sb.append(", configValue=").append(configValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
