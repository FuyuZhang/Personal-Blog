package com.gdufs.finalexam.controller.admin;

import com.gdufs.finalexam.entity.AdminUser;
import com.gdufs.finalexam.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 后台管理功能控制器。
 * 该控制器包含管理员登录、后台首页数据统计展示、
 * 用户信息修改及登出功能。
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminUserService adminUserService;
    @Resource
    private BlogService blogService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private TagService tagService;
    @Resource
    private CommentService commentService;

    /**
     * 登录页面
     * @return 返回登录页面模板路径
     */
    @GetMapping({"/login"})
    public String login() {
        return "admin/login";
    }

    /**
     * 后台首页
     *
     * @param request HttpServletRequest 用于设置统计数据到请求域
     * @return 返回后台首页模板路径
     */
    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        request.setAttribute("categoryCount", categoryService.getTotalCategories());
        request.setAttribute("blogCount", blogService.getTotalBlogs());
        request.setAttribute("tagCount", tagService.getTotalTags());
        request.setAttribute("commentCount", commentService.getTotalComments());
        return "admin/index";
    }

    /**
     * 登录校验
     *
     * @param userName   用户名
     * @param password   密码
     * @param session    HttpSession 用于存储登录状态
     * @return 验证通过返回后台首页，失败返回登录页面
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession session) {
        if (!StringUtils.hasText(userName) || !StringUtils.hasText(password)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        AdminUser adminUser = adminUserService.login(userName, password);
        if (adminUser != null) {
            session.setAttribute("loginUser", adminUser.getNickName());
            session.setAttribute("loginUserId", adminUser.getAdminUserId());
            return "redirect:/admin/index";
        } else {
            session.setAttribute("errorMsg", "登陆失败");
            return "admin/login";
        }
    }

    /**
     * 个人资料页面
     *
     * @param request HttpServletRequest 用于获取当前登录用户信息
     * @return 返回个人资料页面模板路径
     */
    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        AdminUser adminUser = adminUserService.getUserDetailById(loginUserId);
        if (adminUser == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("loginUserName", adminUser.getLoginUserName());
        request.setAttribute("nickName", adminUser.getNickName());
        return "admin/profile";
    }

    /**
     * 更新密码
     *
     * @param request          HttpServletRequest 用于获取当前登录用户ID
     * @param originalPassword 原密码
     * @param newPassword      新密码
     * @return 成功返回 "success"，失败返回错误信息
     */
    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(HttpServletRequest request,
                                 @RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword) {
        if (!StringUtils.hasText(originalPassword) || !StringUtils.hasText(newPassword)) {
            return "参数不能为空";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updatePassword(loginUserId, originalPassword, newPassword)) {
            request.getSession().invalidate(); // 清空Session
            return "success";
        } else {
            return "修改失败";
        }
    }

    /**
     * 更新用户名和昵称
     *
     * @param request       HttpServletRequest 用于获取当前登录用户ID
     * @param loginUserName 新用户名
     * @param nickName      新昵称
     * @return 成功返回 "success"，失败返回错误信息
     */
    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(HttpServletRequest request,
                             @RequestParam("loginUserName") String loginUserName,
                             @RequestParam("nickName") String nickName) {
        if (!StringUtils.hasText(loginUserName) || !StringUtils.hasText(nickName)) {
            return "参数不能为空";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updateName(loginUserId, loginUserName, nickName)) {
            return "success";
        } else {
            return "修改失败";
        }
    }

    /**
     * 登出功能
     *
     * @param request HttpServletRequest 用于清空当前用户的Session
     * @return 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "admin/login";
    }
}
