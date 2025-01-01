package com.gdufs.finalexam.service;

import com.gdufs.finalexam.entity.Blog;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;
import com.gdufs.finalexam.vo.BlogDetailVO;
import com.gdufs.finalexam.vo.SimpleBlogListVO;

import java.util.List;

public interface BlogService {

    /**
     * 保存博客信息。
     * 将一个新的博客对象保存到数据库中，返回保存的结果信息。
     *
     * @param blog 需要保存的博客对象
     * @return 返回保存操作的结果信息，可能为保存成功或失败的信息
     */
    String saveBlog(Blog blog);

    /**
     * 获取博客的分页列表。
     * 根据分页参数返回分页后的博客数据。
     *
     * @param pageUtil 分页查询工具，包含当前页码和每页显示的条目数
     * @return 返回分页结果，包含博客数据及相关分页信息
     */
    PageResult getBlogsPage(PageQueryUtil pageUtil);

    /**
     * 批量删除博客。
     * 根据传入的博客 ID 数组删除对应的博客文章。
     *
     * @param ids 需要删除的博客 ID 数组
     * @return 如果删除成功，返回 true；否则返回 false
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 获取博客总数。
     * 返回系统中所有博客的总数，用于分页和统计等。
     *
     * @return 返回博客的总数
     */
    int getTotalBlogs();

    /**
     * 根据博客 ID 获取博客详情。
     * 根据传入的博客 ID，获取对应博客的详细信息。
     *
     * @param blogId 博客 ID
     * @return 返回指定博客 ID 的博客对象
     */
    Blog getBlogById(Long blogId);

    /**
     * 后台修改博客信息。
     * 更新指定博客的信息。
     *
     * @param blog 需要更新的博客对象，包含更新后的信息
     * @return 返回修改操作的结果信息，可能为成功或失败的信息
     */
    String updateBlog(Blog blog);

    /**
     * 获取首页文章列表。
     * 返回首页所需的博客文章列表，支持分页显示。
     *
     * @param page 当前页码
     * @return 返回分页后的博客列表
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * 获取首页侧边栏的博客列表。
     * 根据传入的类型获取侧边栏显示的博客列表，支持按点击量或发布时间排序。
     *
     * @param type 0-按点击最多排序，1-按最新发布排序
     * @return 返回侧边栏的博客列表
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);

    /**
     * 获取文章详情。
     * 根据博客 ID 获取博客的详细内容，返回详细的博客视图对象。
     *
     * @param blogId 博客 ID
     * @return 返回博客详情视图对象
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * 根据标签获取博客列表。
     * 获取指定标签下的博客文章，支持分页。
     *
     * @param tagName 标签名称
     * @param page 当前页码
     * @return 返回指定标签下的博客分页列表
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 根据分类获取博客列表。
     * 获取指定分类下的博客文章，支持分页。
     *
     * @param categoryId 分类 ID
     * @param page 当前页码
     * @return 返回指定分类下的博客分页列表
     */
    PageResult getBlogsPageByCategory(String categoryId, int page);

    /**
     * 根据搜索关键词获取博客列表。
     * 获取与指定关键词相关的博客文章，支持分页。
     *
     * @param keyword 搜索关键词
     * @param page 当前页码
     * @return 返回与关键词相关的博客分页列表
     */
    PageResult getBlogsPageBySearch(String keyword, int page);

    /**
     * 根据子 URL 获取博客详情。
     * 获取具有指定子 URL 的博客文章，返回文章的详细信息。
     *
     * @param subUrl 博客的子 URL
     * @return 返回指定子 URL 对应的博客详情视图对象
     */
    BlogDetailVO getBlogDetailBySubUrl(String subUrl);
}
