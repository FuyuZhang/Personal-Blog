package com.gdufs.finalexam.controller.admin;

import com.gdufs.finalexam.service.ConfigService;
import com.gdufs.finalexam.utils.Result;
import com.gdufs.finalexam.utils.ResultGenerator;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 配置管理控制器
 */
@Controller
@RequestMapping("/admin")
public class ConfigurationController {

    @Resource
    private ConfigService configService;

    /**
     * 显示所有配置信息页面
     */
    @GetMapping("/configurations")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "configurations");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "admin/configuration";
    }

    /**
     * 更新网站基本信息（网站名称、描述、Logo、图标）
     */
    @PostMapping("/configurations/website")
    @ResponseBody
    public Result website(@RequestParam(value = "websiteName", required = false) String websiteName,
                          @RequestParam(value = "websiteDescription", required = false) String websiteDescription,
                          @RequestParam(value = "websiteLogo", required = false) String websiteLogo,
                          @RequestParam(value = "websiteIcon", required = false) String websiteIcon) {
        int updateResult = 0;
        if (StringUtils.hasText(websiteName)) {
            updateResult += configService.updateConfig("websiteName", websiteName);
        }
        if (StringUtils.hasText(websiteDescription)) {
            updateResult += configService.updateConfig("websiteDescription", websiteDescription);
        }
        if (StringUtils.hasText(websiteLogo)) {
            updateResult += configService.updateConfig("websiteLogo", websiteLogo);
        }
        if (StringUtils.hasText(websiteIcon)) {
            updateResult += configService.updateConfig("websiteIcon", websiteIcon);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }

    /**
     * 更新用户信息（头像、姓名、电子邮件）
     */
    @PostMapping("/configurations/userInfo")
    @ResponseBody
    public Result userInfo(@RequestParam(value = "yourAvatar", required = false) String yourAvatar,
                           @RequestParam(value = "yourName", required = false) String yourName,
                           @RequestParam(value = "yourEmail", required = false) String yourEmail) {
        int updateResult = 0;
        if (StringUtils.hasText(yourAvatar)) {
            updateResult += configService.updateConfig("yourAvatar", yourAvatar);
        }
        if (StringUtils.hasText(yourName)) {
            updateResult += configService.updateConfig("yourName", yourName);
        }
        if (StringUtils.hasText(yourEmail)) {
            updateResult += configService.updateConfig("yourEmail", yourEmail);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }

}