package com.gdufs.finalexam.controller.blog;

import cn.hutool.captcha.ShearCaptcha;
import com.gdufs.finalexam.config.Constants;
import com.gdufs.finalexam.entity.BlogComment;
import com.gdufs.finalexam.entity.BlogLink;
import com.gdufs.finalexam.service.*;
import com.gdufs.finalexam.utils.*;
import com.gdufs.finalexam.vo.BlogDetailVO;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 博客控制器，负责处理博客相关的请求
 */
@Controller
public class MyBlogController {
    // 设置主题，默认使用 Constants.THEME3
    public static String theme = Constants.THEME3;

    // 注入相关的服务类
    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;
    @Resource
    private LinkService linkService;
    @Resource
    private CommentService commentService;
    @Resource
    private ConfigService configService;
    @Resource
    private CategoryService categoryService;

    /**
     * 主页请求，默认返回第一页
     */
    @GetMapping({"/", "/index", "index.html"})
    public String index(HttpServletRequest request) {
        return this.page(request, 1);
    }

    /**
     * 首页分页显示博客数据
     */
    @GetMapping({"/page/{pageNum}"})
    public String page(HttpServletRequest request, @PathVariable("pageNum") int pageNum) {
        // 获取首页的博客分页数据
        PageResult blogPageResult = blogService.getBlogsForIndexPage(pageNum);
        // 若没有数据，返回404错误页面
        if (blogPageResult == null) {
            return "error/error_404";
        }
        // 设置请求属性
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("pageName", "首页");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/index";
    }

    /**
     * 分类页面，包含分类和标签的数据
     */
    @GetMapping({"/categories"})
    public String categories(HttpServletRequest request) {
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.setAttribute("pageName", "分类");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/category";
    }

    /**
     * 博客详情页
     */
    @GetMapping({"/blog/{blogId}", "/article/{blogId}"})
    public String detail(HttpServletRequest request, @PathVariable("blogId") Long blogId, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
        // 获取博客详细信息
        BlogDetailVO blogDetailVO = blogService.getBlogDetail(blogId);
        // 若获取到详细信息，设置请求属性
        if (blogDetailVO != null) {
            request.setAttribute("blogDetailVO", blogDetailVO);
            request.setAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
        }
        request.setAttribute("pageName", "详情");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/detail";
    }

    /**
     * 根据标签名称展示标签页面，默认为第一页
     */
    @GetMapping({"/tag/{tagName}"})
    public String tag(HttpServletRequest request, @PathVariable("tagName") String tagName) {
        return tag(request, tagName, 1);
    }

    /**
     * 根据标签名称展示标签页面，支持分页
     */
    @GetMapping({"/tag/{tagName}/{page}"})
    public String tag(HttpServletRequest request, @PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        // 获取分页后的博客数据
        PageResult blogPageResult = blogService.getBlogsPageByTag(tagName, page);
        // 设置请求属性
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "标签");
        request.setAttribute("pageUrl", "tag");
        request.setAttribute("keyword", tagName);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }

    /**
     * 根据分类名称展示分类页面，默认为第一页
     */
    @GetMapping({"/category/{categoryName}"})
    public String category(HttpServletRequest request, @PathVariable("categoryName") String categoryName) {
        return category(request, categoryName, 1);
    }

    /**
     * 根据分类名称展示分类页面，支持分页
     */
    @GetMapping({"/category/{categoryName}/{page}"})
    public String category(HttpServletRequest request, @PathVariable("categoryName") String categoryName, @PathVariable("page") Integer page) {
        // 获取分页后的博客数据
        PageResult blogPageResult = blogService.getBlogsPageByCategory(categoryName, page);
        // 设置请求属性
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "分类");
        request.setAttribute("pageUrl", "category");
        request.setAttribute("keyword", categoryName);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }

    /**
     * 搜索页面，支持分页
     */
    @GetMapping({"/search/{keyword}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword) {
        return search(request, keyword, 1);
    }

    /**
     * 搜索页面，支持分页
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {
        // 获取搜索结果的分页数据
        PageResult blogPageResult = blogService.getBlogsPageBySearch(keyword, page);
        // 设置请求属性
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "搜索");
        request.setAttribute("pageUrl", "search");
        request.setAttribute("keyword", keyword);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }

    /**
     * 友情链接页面
     */
    @GetMapping({"/link"})
    public String link(HttpServletRequest request) {
        request.setAttribute("pageName", "友链");
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
        // 根据友链的类别进行数据封装
        if (linkMap != null) {
            if (linkMap.containsKey((byte) 0)) {
                request.setAttribute("favoriteLinks", linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) 1)) {
                request.setAttribute("recommendLinks", linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) 2)) {
                request.setAttribute("personalLinks", linkMap.get((byte) 2));
            }
        }
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/link";
    }

    /**
     * 提交评论操作
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long blogId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String email,
                          @RequestParam String websiteUrl, @RequestParam String commentBody) {
        // 校验验证码是否为空
        if (!StringUtils.hasText(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        // 校验验证码是否正确
        ShearCaptcha shearCaptcha = (ShearCaptcha) session.getAttribute("verifyCode");
        if (shearCaptcha == null || !shearCaptcha.verify(verifyCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        // 校验请求来源是否合法
        String ref = request.getHeader("Referer");
        if (!StringUtils.hasText(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        // 校验博客ID是否合法
        if (null == blogId || blogId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        // 校验评论者信息
        if (!StringUtils.hasText(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (!StringUtils.hasText(email)) {
            return ResultGenerator.genFailResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResultGenerator.genFailResult("请输入正确的邮箱地址");
        }
        if (!StringUtils.hasText(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        // 创建评论对象并保存
        BlogComment comment = new BlogComment();
        comment.setBlogId(blogId);
        comment.setCommentator(MyBlogUtil.cleanString(commentator));
        comment.setEmail(email);
        if (PatternUtil.isURL(websiteUrl)) {
            comment.setWebsiteUrl(websiteUrl);
        }
        comment.setCommentBody(MyBlogUtil.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }

    /**
     * 根据subUrl获取关于页面或其它配置的文章页
     */
    @GetMapping({"/{subUrl}"})
    public String detail(HttpServletRequest request, @PathVariable("subUrl") String subUrl) {
        BlogDetailVO blogDetailVO = blogService.getBlogDetailBySubUrl(subUrl);
        // 若获取到详细信息，设置请求属性
        if (blogDetailVO != null) {
            request.setAttribute("blogDetailVO", blogDetailVO);
            request.setAttribute("pageName", subUrl);
            request.setAttribute("configurations", configService.getAllConfigs());
            return "blog/" + theme + "/detail";
        } else {
            return "error/error_400"; // 返回错误页面
        }
    }
}
