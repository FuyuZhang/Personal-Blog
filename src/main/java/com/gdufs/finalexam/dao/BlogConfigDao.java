package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.BlogConfig;

import java.util.List;

/**
 * BlogConfigDao 接口
 *
 * 该接口用于处理 BlogConfig 实体类的数据访问操作，主要包括对博客配置记录的查询和更新操作。
 * BlogConfigDao 提供了获取博客配置信息的功能，允许通过配置名称查询配置信息，同时支持更新配置信息。
 *
 * 主要方法包括：
 * - 查询所有博客配置
 * - 根据配置名称查询特定的博客配置
 * - 更新博客配置
 */
public interface BlogConfigDao {

    /**
     * 查询所有博客配置
     *
     * @return 博客配置列表
     */
    List<BlogConfig> selectAll();

    /**
     * 根据配置名称查询特定的博客配置
     *
     * @param configName 配置名称
     * @return 查询到的 BlogConfig 对象
     */
    BlogConfig selectByPrimaryKey(String configName);

    /**
     * 更新指定 BlogConfig 的非空字段
     *
     * @param record 更新的 BlogConfig 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BlogConfig record);
}
