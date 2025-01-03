package com.gdufs.finalexam.controller.admin;

import com.gdufs.finalexam.service.CommentService;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.Result;
import com.gdufs.finalexam.utils.ResultGenerator;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 后台评论管理控制器
 */
@Controller
@RequestMapping("/admin")
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
     * 获取评论分页列表
     */
    @GetMapping("/comments/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(commentService.getCommentsPage(pageUtil));
    }

    /**
     * 批量审核评论
     */
    @PostMapping("/comments/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (commentService.checkDone(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("审核失败");
        }
    }

    /**
     * 回复评论
     */
    @PostMapping("/comments/reply")
    @ResponseBody
    public Result reply(@RequestParam("commentId") Long commentId,
                        @RequestParam("replyBody") String replyBody) {
        if (commentId == null || commentId < 1 || !StringUtils.hasText(replyBody)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (commentService.reply(commentId, replyBody)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("回复失败");
        }
    }

    /**
     * 批量删除评论
     */
    @PostMapping("/comments/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (commentService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 跳转到评论管理页面
     */
    @GetMapping("/comments")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }
}