package com.gdufs.finalexam.service;

import com.gdufs.finalexam.entity.BlogCategory;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;

import java.util.List;

public interface CategoryService {

    /**
     * 查询分类的分页数据。
     * 根据分页查询工具返回分页后的博客分类数据。
     *
     * @param pageUtil 分页查询工具，包含当前页码和每页显示的条目数
     * @return 返回分页结果，包含分类数据及相关分页信息
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    /**
     * 获取博客分类总数。
     * 返回当前系统中所有博客分类的总数，用于统计和分页等操作。
     *
     * @return 返回博客分类的总数
     */
    int getTotalCategories();

    /**
     * 添加分类数据。
     * 保存新的博客分类，包括分类名称和分类图标。
     *
     * @param categoryName 分类名称
     * @param categoryIcon 分类图标
     * @return 如果添加成功，返回 true；否则返回 false
     */
    Boolean saveCategory(String categoryName, String categoryIcon);

    /**
     * 更新分类数据。
     * 根据分类 ID 更新指定分类的名称和图标。
     *
     * @param categoryId 分类 ID
     * @param categoryName 更新后的分类名称
     * @param categoryIcon 更新后的分类图标
     * @return 如果更新成功，返回 true；否则返回 false
     */
    Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    /**
     * 批量删除分类。
     * 根据传入的分类 ID 数组删除对应的分类数据。
     *
     * @param ids 需要删除的分类 ID 数组
     * @return 如果删除成功，返回 true；否则返回 false
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 获取所有分类。
     * 返回系统中所有的博客分类列表，适用于不分页的查询。
     *
     * @return 返回所有博客分类的列表
     */
    List<BlogCategory> getAllCategories();
}
