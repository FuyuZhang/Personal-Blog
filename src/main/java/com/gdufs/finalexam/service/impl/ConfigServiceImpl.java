package com.gdufs.finalexam.service.impl;

import com.gdufs.finalexam.dao.BlogConfigDao;
import com.gdufs.finalexam.entity.BlogConfig;
import com.gdufs.finalexam.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import jakarta.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private BlogConfigDao blogConfigDao;

    public static final String websiteName = "personal blog";
    public static final String websiteDescription = "期末搭建的超级容易破防的个人博客";
    public static final String websiteLogo = "/admin/dist/img/logo2.png";
    public static final String websiteIcon = "/admin/dist/img/favicon.ico";

    public static final String yourAvatar = "/admin/dist/img/avatar.png";
    public static final String yourEmail = "yyyyyyyyy@qq.com";
    public static final String yourName = "JF";

    @Override
    public int updateConfig(String configName, String configValue) {
        BlogConfig blogConfig = blogConfigDao.selectByPrimaryKey(configName);
        if (blogConfig != null) {
            blogConfig.setConfigValue(configValue);
            blogConfig.setUpdateTime(new Date());
            return blogConfigDao.updateByPrimaryKeySelective(blogConfig);
        }
        return 0;
    }

    @Override
    public Map<String, String> getAllConfigs() {
        // 获取所有的map并封装为map
        List<BlogConfig> blogConfigs = blogConfigDao.selectAll();
        Map<String, String> configMap = blogConfigs.stream().collect(Collectors.toMap(BlogConfig::getConfigName, BlogConfig::getConfigValue));
        for (Map.Entry<String, String> config : configMap.entrySet()) {
            if ("websiteName".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteName);
            }
            if ("websiteDescription".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteDescription);
            }
            if ("websiteLogo".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteLogo);
            }
            if ("websiteIcon".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(websiteIcon);
            }
            if ("yourAvatar".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(yourAvatar);
            }
            if ("yourEmail".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(yourEmail);
            }
            if ("yourName".equals(config.getKey()) && !StringUtils.hasText(config.getValue())) {
                config.setValue(yourName);
            }

        }
        return configMap;
    }
}
