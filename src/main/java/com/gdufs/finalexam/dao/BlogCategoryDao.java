package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.BlogCategory;
import com.gdufs.finalexam.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BlogCategoryDao 接口
 *
 * 该接口用于处理 BlogCategory 实体类的数据访问操作，包含了对 BlogCategory 记录的增、删、改、查等常见操作。
 * 所有的方法都定义了对 BlogCategory 表的操作，支持基于主键查询、按条件查询、批量删除以及分页查询等功能。
 * 该接口使用了 MyBatis 框架，并通过 SQL 映射文件实现具体的数据库操作。
 */
public interface BlogCategoryDao {

    /**
     * 根据主键删除 BlogCategory
     *
     * @param categoryId 主键 ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * 插入一条 BlogCategory 记录
     *
     * @param record BlogCategory 对象
     * @return 插入的记录数
     */
    int insert(BlogCategory record);

    /**
     * 插入一条 BlogCategory 记录，插入的字段为非空字段
     *
     * @param record BlogCategory 对象
     * @return 插入的记录数
     */
    int insertSelective(BlogCategory record);

    /**
     * 根据主键查询 BlogCategory
     *
     * @param categoryId 主键 ID
     * @return 查询到的 BlogCategory 对象
     */
    BlogCategory selectByPrimaryKey(Integer categoryId);

    /**
     * 根据类别名称查询 BlogCategory
     *
     * @param categoryName 类别名称
     * @return 查询到的 BlogCategory 对象
     */
    BlogCategory selectByCategoryName(String categoryName);

    /**
     * 根据主键更新 BlogCategory 的非空字段
     *
     * @param record 更新的 BlogCategory 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BlogCategory record);

    /**
     * 根据主键更新 BlogCategory 的所有字段
     *
     * @param record 更新的 BlogCategory 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(BlogCategory record);

    /**
     * 分页查询 BlogCategory 列表
     *
     * @param pageUtil 分页查询工具
     * @return 查询到的 BlogCategory 列表
     */
    List<BlogCategory> findCategoryList(PageQueryUtil pageUtil);

    /**
     * 根据类别 ID 列表查询 BlogCategory 列表
     *
     * @param categoryIds 类别 ID 列表
     * @return 查询到的 BlogCategory 列表
     */
    List<BlogCategory> selectByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);

    /**
     * 获取 BlogCategory 总数
     *
     * @param pageUtil 分页查询工具
     * @return 总数
     */
    int getTotalCategories(PageQueryUtil pageUtil);

    /**
     * 批量删除 BlogCategory
     *
     * @param ids BlogCategory 的 ID 列表
     * @return 删除的记录数
     */
    int deleteBatch(Integer[] ids);
}
