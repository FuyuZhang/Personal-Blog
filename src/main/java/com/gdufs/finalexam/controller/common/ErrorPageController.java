package com.gdufs.finalexam.controller.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * ErrorPageController 处理错误页面的显示。
 * 实现了 ErrorViewResolver 接口，根据不同的错误状态码，返回相应的错误页面。
 */
@Controller
public class ErrorPageController implements ErrorViewResolver {

    // 单例模式静态实例
    private static ErrorPageController errorPageController;

    // 注入 ErrorAttributes，用于获取错误信息
    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * 构造方法，接受一个 ErrorAttributes 参数进行初始化
     *
     * @param errorAttributes 错误信息属性
     */
    public ErrorPageController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * 默认构造方法，创建 ErrorPageController 实例时，如果没有已有实例则创建
     */
    public ErrorPageController() {
        if (errorPageController == null) {
            errorPageController = new ErrorPageController(errorAttributes);
        }
    }

    /**
     * 通过状态码判断错误类型，并返回相应的错误页面
     *
     * @param request 请求对象
     * @param status 错误状态码
     * @param model 错误页面的模型数据
     * @return 返回对应状态码的错误页面
     */
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request,
                                         HttpStatus status,
                                         Map<String, Object> model) {
        // 如果是 400 错误，返回错误页面 "error/error_400"
        if (HttpStatus.BAD_REQUEST == status) {
            return new ModelAndView("error/error_400");
        }
        // 如果是 404 错误，返回错误页面 "error/error_404"
        else if (HttpStatus.NOT_FOUND == status) {
            return new ModelAndView("error/error_404");
        }
        // 如果是其他错误，返回错误页面 "error/error_5xx"
        else {
            return new ModelAndView("error/error_5xx");
        }
    }
}