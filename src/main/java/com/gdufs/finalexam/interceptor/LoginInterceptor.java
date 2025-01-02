package com.gdufs.finalexam.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 身份验证拦截器，用于在请求处理之前检查用户是否已登录。
 * 如果请求路径为管理员相关路径且用户未登录，则会重定向到登录页面。
 * 登录用户信息存储在会话的 "loginUser" 属性中。
 * 如果用户未登录且请求为管理员页面，将提示重新登录信息，并重定向到登录页面。
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前执行身份验证。
     * 如果请求是管理员路径且用户未登录，则重定向到登录页面。
     *
     * @param request 当前的 HTTP 请求对象
     * @param response 当前的 HTTP 响应对象
     * @param o 处理器对象（通常是控制器）
     * @return 如果返回 true，表示继续请求处理；如果返回 false，表示请求被拦截，响应已发送
     * @throws Exception 如果发生任何异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws Exception {
        // 获取当前请求的路径
        String requestServletPath = request.getServletPath();

        // 判断是否是以 "/admin" 开头的请求，并且用户未登录
        if (requestServletPath.startsWith("/admin")
                && null == request.getSession().getAttribute("loginUser")) {
            // 如果未登录，则设置错误消息，并重定向到登录页面
            request.getSession().setAttribute("errorMsg", "请重新登陆");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;  // 拦截请求，不继续执行
        } else {
            // 如果用户已登录，移除错误消息
            request.getSession().removeAttribute("errorMsg");
            return true;  // 允许请求继续执行
        }
    }

    /**
     * 在请求处理后但在视图渲染之前执行。
     * 目前该方法为空，可以用于在请求处理后进行一些附加操作。
     *
     * @param httpServletRequest 当前的 HTTP 请求对象
     * @param httpServletResponse 当前的 HTTP 响应对象
     * @param o 处理器对象（通常是控制器）
     * @param modelAndView 存储控制器处理后的模型数据和视图信息
     * @throws Exception 如果发生任何异常
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    /**
     * 请求处理完毕后执行，主要用于清理操作。
     * 目前该方法为空，可以用于请求完成后的其他处理。
     *
     * @param httpServletRequest 当前的 HTTP 请求对象
     * @param httpServletResponse 当前的 HTTP 响应对象
     * @param o 处理器对象（通常是控制器）
     * @param e 处理过程中发生的异常
     * @throws Exception 如果发生任何异常
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o,
                                Exception e) throws Exception {

    }
}
