package com.gdufs.finalexam.service;

import com.gdufs.finalexam.entity.BlogComment;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;

public interface CommentService {

    /**
     * 添加评论。
     * 将用户提交的评论数据保存到数据库中，进行评论内容的添加。
     *
     * @param blogComment 评论数据对象，包含评论的内容、评论者等信息
     * @return 如果评论添加成功，返回 true；否则返回 false
     */
    Boolean addComment(BlogComment blogComment);

    /**
     * 后台管理系统中评论分页功能。
     * 通过分页查询工具获取所有评论的分页数据，适用于后台管理的评论展示。
     *
     * @param pageUtil 分页查询工具，包含当前页码和每页显示的条目数
     * @return 返回分页结果，包含评论数据及相关分页信息
     */
    PageResult getCommentsPage(PageQueryUtil pageUtil);

    /**
     * 获取评论的总数。
     * 返回系统中所有评论的总数，用于统计和分页等操作。
     *
     * @return 返回评论的总数
     */
    int getTotalComments();

    /**
     * 批量审核评论。
     * 根据评论 ID 数组进行批量审核操作，将选中的评论标记为审核通过。
     *
     * @param ids 需要审核的评论 ID 数组
     * @return 如果审核成功，返回 true；否则返回 false
     */
    Boolean checkDone(Integer[] ids);

    /**
     * 批量删除评论。
     * 根据评论 ID 数组删除指定的评论。
     *
     * @param ids 需要删除的评论 ID 数组
     * @return 如果删除成功，返回 true；否则返回 false
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 添加回复。
     * 针对指定评论，添加回复内容，进行评论的回复操作。
     *
     * @param commentId 要回复的评论 ID
     * @param replyBody 回复的内容
     * @return 如果回复成功，返回 true；否则返回 false
     */
    Boolean reply(Long commentId, String replyBody);

    /**
     * 根据文章 id 和分页参数获取文章的评论列表。
     * 根据给定的文章 ID 和页码，查询该文章下的评论数据，并返回分页结果。
     *
     * @param blogId 文章的 ID
     * @param page 当前页码
     * @return 返回该文章的评论分页数据
     */
    PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page);
}
