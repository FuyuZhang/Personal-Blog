package com.gdufs.finalexam.service;

import com.gdufs.finalexam.entity.BlogLink;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;

import java.util.List;
import java.util.Map;

public interface LinkService {

    /**
     * 查询友链的分页数据。
     * 根据分页参数获取博客的友链数据，适用于后台管理系统的友链列表展示。
     *
     * @param pageUtil 分页查询参数
     * @return 返回分页结果，包括友链数据及分页信息
     */
    PageResult getBlogLinkPage(PageQueryUtil pageUtil);

    /**
     * 获取所有友链的数量。
     * 查询并返回系统中所有友链的总数，用于分页显示时计算总页数。
     *
     * @return 返回友链的总数量
     */
    int getTotalLinks();

    /**
     * 添加新的友链。
     * 根据传入的 `BlogLink` 对象，保存新的友链信息。
     *
     * @param link 需要保存的友链对象
     * @return 返回保存是否成功
     */
    Boolean saveLink(BlogLink link);

    /**
     * 根据友链 ID 查询友链信息。
     * 根据指定的友链 ID 查询并返回对应的 `BlogLink` 信息。
     *
     * @param id 友链的 ID
     * @return 返回对应 ID 的 `BlogLink` 对象
     */
    BlogLink selectById(Integer id);

    /**
     * 更新友链信息。
     * 根据传入的友链对象更新现有友链的相关信息。
     *
     * @param tempLink 需要更新的友链对象
     * @return 返回更新是否成功
     */
    Boolean updateLink(BlogLink tempLink);

    /**
     * 批量删除友链。
     * 根据传入的友链 ID 数组，批量删除对应的友链信息。
     *
     * @param ids 需要删除的友链 ID 数组
     * @return 返回批量删除操作是否成功
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回友链页面所需的所有数据。
     * 获取友链页面展示所需的所有数据，按友链类型进行分组。
     *
     * @return 返回一个 `Map`，键为友链类型，值为相应的友链列表
     */
    Map<Byte, List<BlogLink>> getLinksForLinkPage();
}
