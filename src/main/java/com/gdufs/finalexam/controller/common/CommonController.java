package com.gdufs.finalexam.controller.common;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CommonController 类，处理公共的请求，例如验证码生成
 */
@Controller
public class CommonController {

    /**
     * 生成验证码并返回给客户端
     *
     * @param httpServletRequest 用于获取当前请求的session
     * @param httpServletResponse 用于返回图片流给客户端
     * @throws Exception 可能抛出的异常
     */
    @GetMapping("/common/kaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws Exception {
        // 禁止浏览器缓存验证码图片
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        // 设置返回的内容类型为图片
        httpServletResponse.setContentType("image/png");

        // 创建一个带有四个字符、两条干扰线的验证码
        ShearCaptcha shearCaptcha = CaptchaUtil
                .createShearCaptcha(150, 30, 4, 2);

        // 将生成的验证码对象存入session，供后续验证使用
        httpServletRequest.getSession().setAttribute("verifyCode", shearCaptcha);

        // 将验证码图片写入响应输出流，直接返回给客户端
        shearCaptcha.write(httpServletResponse.getOutputStream());
    }
}
