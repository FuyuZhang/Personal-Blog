package com.gdufs.finalexam.service;

import com.gdufs.finalexam.entity.BlogTagCount;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;

import java.util.List;

public interface TagService {

    /**
     * 查询标签的分页数据。
     * 根据分页查询参数，获取博客标签的分页数据，适用于后台管理系统中标签列表的展示。
     *
     * @param pageUtil 分页查询参数
     * @return 返回分页结果，包括标签数据及分页信息
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    /**
     * 获取所有标签的数量。
     * 查询并返回系统中所有标签的总数，用于分页显示时计算总页数。
     *
     * @return 返回标签的总数量
     */
    int getTotalTags();

    /**
     * 添加新标签。
     * 根据传入的标签名称保存新的标签信息。
     *
     * @param tagName 标签的名称
     * @return 返回标签保存是否成功
     */
    Boolean saveTag(String tagName);

    /**
     * 批量删除标签。
     * 根据传入的标签 ID 数组，批量删除对应的标签。
     *
     * @param ids 需要删除的标签 ID 数组
     * @return 返回批量删除操作是否成功
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 获取首页标签统计数据。
     * 获取首页展示所需的标签统计数据，用于显示标签的使用频率或热门程度。
     *
     * @return 返回标签统计信息列表
     */
    List<BlogTagCount> getBlogTagCountForIndex();
}
