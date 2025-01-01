package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.BlogTag;
import com.gdufs.finalexam.entity.BlogTagCount;
import com.gdufs.finalexam.utils.PageQueryUtil;

import java.util.List;

/**
 * BlogTagDao 接口
 *
 * 该接口负责处理 BlogTag 实体类的数据访问操作。BlogTagDao 提供了对博客标签记录的管理功能，包括增删改查等基本操作。
 * 主要包括：
 * - 增加博客标签记录
 * - 删除博客标签记录
 * - 更新博客标签记录
 * - 查询博客标签记录
 * - 获取标签的数量统计
 * - 支持分页查询博客标签记录
 * - 批量插入标签记录
 *
 * BlogTagDao 适用于管理博客中的标签，用于标记博客的主题或内容，以便用户更方便地浏览相关的博客文章。
 */
public interface BlogTagDao {

    /**
     * 根据主键删除博客标签记录
     *
     * @param tagId 博客标签 ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Integer tagId);

    /**
     * 插入一条 BlogTag 记录
     *
     * @param record BlogTag 对象
     * @return 插入的记录数
     */
    int insert(BlogTag record);

    /**
     * 插入一条 BlogTag 记录，插入的字段为非空字段
     *
     * @param record BlogTag 对象
     * @return 插入的记录数
     */
    int insertSelective(BlogTag record);

    /**
     * 根据主键查询 BlogTag 对象
     *
     * @param tagId 博客标签 ID
     * @return 查询到的 BlogTag 对象
     */
    BlogTag selectByPrimaryKey(Integer tagId);

    /**
     * 根据标签名查询 BlogTag 对象
     *
     * @param tagName 标签名称
     * @return 查询到的 BlogTag 对象
     */
    BlogTag selectByTagName(String tagName);

    /**
     * 根据主键更新 BlogTag 的非空字段
     *
     * @param record 更新的 BlogTag 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BlogTag record);

    /**
     * 根据主键更新 BlogTag 的所有字段
     *
     * @param record 更新的 BlogTag 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(BlogTag record);

    /**
     * 根据分页条件查询博客标签列表
     *
     * @param pageUtil 分页查询工具类
     * @return 查询到的博客标签列表
     */
    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    /**
     * 获取所有标签的数量统计
     *
     * @return 标签数量统计列表
     */
    List<BlogTagCount> getTagCount();

    /**
     * 获取符合条件的博客标签记录总数
     *
     * @param pageUtil 分页查询工具类
     * @return 博客标签总数
     */
    int getTotalTags(PageQueryUtil pageUtil);

    /**
     * 批量删除博客标签记录
     *
     * @param ids 博客标签 ID 数组
     * @return 删除的记录数
     */
    int deleteBatch(Integer[] ids);

    /**
     * 批量插入博客标签
     *
     * @param tagList 博客标签列表
     * @return 插入的记录数
     */
    int batchInsertBlogTag(List<BlogTag> tagList);
}
