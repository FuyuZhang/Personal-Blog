package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.Blog;
import com.gdufs.finalexam.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * BlogDao 接口
 *
 * 该接口负责处理 Blog 实体类的所有数据访问操作，涉及到博客的增删改查等基本功能。
 * BlogDao 提供了查询、插入、删除和更新博客记录的功能，同时支持分页查询和按条件筛选博客信息。
 *
 * 主要方法包括：
 * - 增加博客记录
 * - 删除博客记录
 * - 更新博客记录（包括内容、类别等）
 * - 根据博客 ID 或其他条件查询博客
 * - 获取博客列表、按标签或分类查询博客
 */
public interface BlogDao {

    /**
     * 根据主键删除博客记录
     *
     * @param blogId 博客 ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Long blogId);

    /**
     * 插入一条 Blog 记录
     *
     * @param record Blog 对象
     * @return 插入的记录数
     */
    int insert(Blog record);

    /**
     * 插入一条 Blog 记录，插入的字段为非空字段
     *
     * @param record Blog 对象
     * @return 插入的记录数
     */
    int insertSelective(Blog record);

    /**
     * 根据主键查询 Blog 对象
     *
     * @param blogId 博客 ID
     * @return 查询到的 Blog 对象
     */
    Blog selectByPrimaryKey(Long blogId);

    /**
     * 根据主键更新 Blog 的非空字段
     *
     * @param record 更新的 Blog 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * 根据主键更新 Blog 的所有字段（包括大字段）
     *
     * @param record 更新的 Blog 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeyWithBLOBs(Blog record);

    /**
     * 根据主键更新 Blog 的所有字段
     *
     * @param record 更新的 Blog 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(Blog record);

    /**
     * 根据分页信息查询博客列表
     *
     * @param pageUtil 分页查询工具类
     * @return 查询到的博客列表
     */
    List<Blog> findBlogList(PageQueryUtil pageUtil);

    /**
     * 根据博客类型获取博客列表，支持限制返回的博客数量
     *
     * @param type 博客类型
     * @param limit 返回的博客数量
     * @return 博客列表
     */
    List<Blog> findBlogListByType(@Param("type") int type, @Param("limit") int limit);

    /**
     * 获取符合分页条件的博客总数
     *
     * @param pageUtil 分页查询工具类
     * @return 博客总数
     */
    int getTotalBlogs(PageQueryUtil pageUtil);

    /**
     * 批量删除博客
     *
     * @param ids 博客 ID 数组
     * @return 删除的记录数
     */
    int deleteBatch(Integer[] ids);

    /**
     * 根据标签 ID 获取博客分页列表
     *
     * @param pageUtil 分页查询工具类
     * @return 查询到的博客列表
     */
    List<Blog> getBlogsPageByTagId(PageQueryUtil pageUtil);

    /**
     * 根据标签 ID 获取博客总数
     *
     * @param pageUtil 分页查询工具类
     * @return 博客总数
     */
    int getTotalBlogsByTagId(PageQueryUtil pageUtil);

    /**
     * 根据子 URL 查询博客
     *
     * @param subUrl 子 URL
     * @return 查询到的 Blog 对象
     */
    Blog selectBySubUrl(String subUrl);

    /**
     * 更新博客的分类信息
     *
     * @param categoryName 分类名称
     * @param categoryId 分类 ID
     * @param ids 博客 ID 数组
     * @return 更新的记录数
     */
    int updateBlogCategorys(@Param("categoryName") String categoryName,
                            @Param("categoryId") Integer categoryId,
                            @Param("ids") Integer[] ids);
}
