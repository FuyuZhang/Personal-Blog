package com.gdufs.finalexam.controller.admin;

import com.gdufs.finalexam.service.TagService;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.Result;
import com.gdufs.finalexam.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用以标识文章的标签
 * 标签管理控制器，提供对标签的增、删、查操作。
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 进入标签管理页面
     */
    @GetMapping("/tags")
    public String tagPage(HttpServletRequest request) {
        request.setAttribute("path", "tags"); // 设置当前路径为'tags'，用于页面的选中状态
        return "admin/tag"; // 返回标签管理页面的视图
    }

    /**
     * 获取标签列表，带分页功能
     */
    @GetMapping("/tags/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！"); // 如果分页参数缺失，返回错误结果
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(tagService.getBlogTagPage(pageUtil)); // 返回分页查询结果
    }

    /**
     * 保存新的标签
     */
    @PostMapping("/tags/save")
    @ResponseBody
    public Result save(@RequestParam("tagName") String tagName) {
        // 校验标签名称是否有效
        if (!StringUtils.hasText(tagName)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        // 保存标签，若标签名称重复，则返回失败
        if (tagService.saveTag(tagName)) {
            return ResultGenerator.genSuccessResult(); // 保存成功
        } else {
            return ResultGenerator.genFailResult("标签名称重复"); // 标签名称重复，返回失败
        }
    }

    /**
     * 批量删除标签
     */
    @PostMapping("/tags/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        // 校验是否有待删除的标签ID
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！"); // 如果没有ID，返回错误
        }
        // 删除标签，若标签有关联数据则返回失败
        if (tagService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult(); // 删除成功
        } else {
            return ResultGenerator.genFailResult("有关联数据请勿强行删除"); // 如果有关联数据，返回失败
        }
    }

}
