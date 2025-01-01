package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.BlogLink;
import com.gdufs.finalexam.utils.PageQueryUtil;

import java.util.List;

/**
 * BlogLinkDao 接口
 *
 * 该接口负责处理 BlogLink 实体类的数据访问操作。BlogLinkDao 提供了管理博客链接记录的功能，包括增删改查等基本操作。
 * 主要包括：
 * - 增加博客链接记录
 * - 删除博客链接记录
 * - 更新博客链接记录
 * - 查询博客链接记录
 * - 支持分页查询博客链接记录
 *
 * BlogLinkDao 适用于管理博客中的外部链接或导航链接等。
 */
public interface BlogLinkDao {

    /**
     * 根据主键删除博客链接记录
     *
     * @param linkId 博客链接 ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Integer linkId);

    /**
     * 插入一条 BlogLink 记录
     *
     * @param record BlogLink 对象
     * @return 插入的记录数
     */
    int insert(BlogLink record);

    /**
     * 插入一条 BlogLink 记录，插入的字段为非空字段
     *
     * @param record BlogLink 对象
     * @return 插入的记录数
     */
    int insertSelective(BlogLink record);

    /**
     * 根据主键查询 BlogLink 对象
     *
     * @param linkId 博客链接 ID
     * @return 查询到的 BlogLink 对象
     */
    BlogLink selectByPrimaryKey(Integer linkId);

    /**
     * 根据主键更新 BlogLink 的非空字段
     *
     * @param record 更新的 BlogLink 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BlogLink record);

    /**
     * 根据主键更新 BlogLink 的所有字段
     *
     * @param record 更新的 BlogLink 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(BlogLink record);

    /**
     * 根据分页条件查询博客链接列表
     *
     * @param pageUtil 分页查询工具类
     * @return 查询到的博客链接列表
     */
    List<BlogLink> findLinkList(PageQueryUtil pageUtil);

    /**
     * 获取符合条件的博客链接记录总数
     *
     * @param pageUtil 分页查询工具类
     * @return 博客链接总数
     */
    int getTotalLinks(PageQueryUtil pageUtil);

    /**
     * 批量删除博客链接
     *
     * @param ids 博客链接 ID 数组
     * @return 删除的记录数
     */
    int deleteBatch(Integer[] ids);
}
