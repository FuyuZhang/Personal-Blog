package com.gdufs.finalexam.controller.admin;

import com.gdufs.finalexam.entity.BlogLink;
import com.gdufs.finalexam.service.LinkService;
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
 * 友链管理控制器，提供对友链的增、删、改、查操作。
 */
@Controller
@RequestMapping("/admin")
public class LinkController {

    @Resource
    private LinkService linkService;

    /**
     * 进入友链页面
     */
    @GetMapping("/links")
    public String linkPage(HttpServletRequest request) {
        request.setAttribute("path", "links"); // 设置当前路径为'links'，用于页面的选中状态
        return "admin/link"; // 返回友链管理页面的视图
    }

    /**
     * 获取友链列表，带分页功能
     */
    @GetMapping("/links/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！"); // 如果分页参数缺失，返回错误结果
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(linkService.getBlogLinkPage(pageUtil)); // 返回分页查询结果
    }

    /**
     * 添加新的友链
     */
    @RequestMapping(value = "/links/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("linkType") Integer linkType,
                       @RequestParam("linkName") String linkName,
                       @RequestParam("linkUrl") String linkUrl,
                       @RequestParam("linkRank") Integer linkRank,
                       @RequestParam("linkDescription") String linkDescription) {
        // 校验参数是否有效
        if (linkType == null || linkType < 0 || linkRank == null || linkRank < 0 ||
                !StringUtils.hasText(linkName) || !StringUtils.hasText(linkUrl) || !StringUtils.hasText(linkDescription)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        BlogLink link = new BlogLink();
        link.setLinkType(linkType.byteValue());
        link.setLinkRank(linkRank);
        link.setLinkName(linkName);
        link.setLinkUrl(linkUrl);
        link.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.saveLink(link)); // 保存友链信息并返回结果
    }

    /**
     * 查看友链的详情
     */
    @GetMapping("/links/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Integer id) {
        BlogLink link = linkService.selectById(id); // 根据ID查询友链信息
        return ResultGenerator.genSuccessResult(link); // 返回友链信息
    }

    /**
     * 修改已有的友链
     */
    @RequestMapping(value = "/links/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("linkId") Integer linkId,
                         @RequestParam("linkType") Integer linkType,
                         @RequestParam("linkName") String linkName,
                         @RequestParam("linkUrl") String linkUrl,
                         @RequestParam("linkRank") Integer linkRank,
                         @RequestParam("linkDescription") String linkDescription) {
        BlogLink tempLink = linkService.selectById(linkId); // 根据ID查询友链
        if (tempLink == null) {
            return ResultGenerator.genFailResult("无数据！"); // 如果友链不存在，返回错误
        }
        // 校验参数是否有效
        if (linkType == null || linkType < 0 || linkRank == null || linkRank < 0 ||
                !StringUtils.hasText(linkName) || !StringUtils.hasText(linkUrl) || !StringUtils.hasText(linkDescription)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        tempLink.setLinkType(linkType.byteValue());
        tempLink.setLinkRank(linkRank);
        tempLink.setLinkName(linkName);
        tempLink.setLinkUrl(linkUrl);
        tempLink.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.updateLink(tempLink)); // 更新友链并返回结果
    }

    /**
     * 删除友链
     */
    @RequestMapping(value = "/links/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！"); // 如果没有选择删除的ID，返回错误
        }
        if (linkService.deleteBatch(ids)) { // 批量删除友链
            return ResultGenerator.genSuccessResult(); // 删除成功
        } else {
            return ResultGenerator.genFailResult("删除失败"); // 删除失败
        }
    }

}
