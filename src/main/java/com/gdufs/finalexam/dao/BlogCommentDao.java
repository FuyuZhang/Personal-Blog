package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.BlogComment;

import java.util.List;
import java.util.Map;

/**
 * BlogCommentDao 接口
 *
 * 该接口用于处理 BlogComment 实体类的数据访问操作，主要包括对 BlogComment 记录的增、删、改、查等功能。
 * 该接口定义了与数据库交互的操作方法，支持对博客评论的管理，包括评论的添加、删除、更新、查询等功能。
 *
 * 主要方法包括：
 * - 插入评论记录
 * - 根据评论ID查询、更新评论信息
 * - 批量删除评论
 * - 根据特定条件查询博客评论
 */
public interface BlogCommentDao {

    /**
     * 根据主键删除 BlogComment
     *
     * @param commentId 评论ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Long commentId);

    /**
     * 插入一条 BlogComment 记录
     *
     * @param record BlogComment 对象
     * @return 插入的记录数
     */
    int insert(BlogComment record);

    /**
     * 插入一条 BlogComment 记录，插入的字段为非空字段
     *
     * @param record BlogComment 对象
     * @return 插入的记录数
     */
    int insertSelective(BlogComment record);

    /**
     * 根据主键查询 BlogComment
     *
     * @param commentId 评论ID
     * @return 查询到的 BlogComment 对象
     */
    BlogComment selectByPrimaryKey(Long commentId);

    /**
     * 根据主键更新 BlogComment 的非空字段
     *
     * @param record 更新的 BlogComment 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BlogComment record);

    /**
     * 根据主键更新 BlogComment 的所有字段
     *
     * @param record 更新的 BlogComment 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(BlogComment record);

    /**
     * 根据条件查询博客评论列表
     *
     * @param map 查询条件
     * @return 博客评论列表
     */
    List<BlogComment> findBlogCommentList(Map map);

    /**
     * 根据条件获取博客评论总数
     *
     * @param map 查询条件
     * @return 评论总数
     */
    int getTotalBlogComments(Map map);

    /**
     * 批量检查评论是否已完成
     *
     * @param ids 评论ID数组
     * @return 更新的记录数
     */
    int checkDone(Integer[] ids);

    /**
     * 批量删除博客评论
     *
     * @param ids 评论ID数组
     * @return 删除的记录数
     */
    int deleteBatch(Integer[] ids);
}
