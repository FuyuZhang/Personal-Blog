package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.BlogTagRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BlogTagRelationDao 接口
 *
 * 该接口负责处理 BlogTagRelation 实体类的数据访问操作。BlogTagRelationDao 提供了对博客标签关联记录的管理功能，
 * 主要包括博客与标签的关联管理，操作范围涉及博客与标签之间的关系表。通过该接口，可以管理博客与多个标签之间的关联。
 * 该接口的功能包括：
 * - 增加博客标签关系记录
 * - 删除博客标签关系记录
 * - 更新博客标签关系记录
 * - 查询博客与标签的关联
 * - 查询标签的博客 ID 列表
 * - 支持批量插入和批量删除
 *
 * BlogTagRelationDao 适用于博客与标签之间的关系管理，用于表示一个博客可以有多个标签，一个标签也可以关联多个博客。
 */
public interface BlogTagRelationDao {

    /**
     * 根据主键删除博客标签关系记录
     *
     * @param relationId 关系记录 ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Long relationId);

    /**
     * 插入一条 BlogTagRelation 记录
     *
     * @param record BlogTagRelation 对象
     * @return 插入的记录数
     */
    int insert(BlogTagRelation record);

    /**
     * 插入一条 BlogTagRelation 记录，插入的字段为非空字段
     *
     * @param record BlogTagRelation 对象
     * @return 插入的记录数
     */
    int insertSelective(BlogTagRelation record);

    /**
     * 根据主键查询 BlogTagRelation 对象
     *
     * @param relationId 关系记录 ID
     * @return 查询到的 BlogTagRelation 对象
     */
    BlogTagRelation selectByPrimaryKey(Long relationId);

    /**
     * 根据博客 ID 和标签 ID 查询博客标签关系
     *
     * @param blogId 博客 ID
     * @param tagId 标签 ID
     * @return 查询到的 BlogTagRelation 对象
     */
    BlogTagRelation selectByBlogIdAndTagId(@Param("blogId") Long blogId, @Param("tagId") Integer tagId);

    /**
     * 根据标签 ID 数组查询所有不同的标签 ID 列表
     *
     * @param tagIds 标签 ID 数组
     * @return 不同的标签 ID 列表
     */
    List<Long> selectDistinctTagIds(Integer[] tagIds);

    /**
     * 根据主键更新 BlogTagRelation 的非空字段
     *
     * @param record 更新的 BlogTagRelation 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BlogTagRelation record);

    /**
     * 根据主键更新 BlogTagRelation 的所有字段
     *
     * @param record 更新的 BlogTagRelation 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(BlogTagRelation record);

    /**
     * 批量插入博客标签关系记录
     *
     * @param blogTagRelationList 博客标签关系列表
     * @return 插入的记录数
     */
    int batchInsert(@Param("relationList") List<BlogTagRelation> blogTagRelationList);

    /**
     * 根据博客 ID 删除所有相关的标签关系记录
     *
     * @param blogId 博客 ID
     * @return 删除的记录数
     */
    int deleteByBlogId(Long blogId);
}
