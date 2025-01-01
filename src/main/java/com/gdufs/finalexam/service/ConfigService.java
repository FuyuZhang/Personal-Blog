package com.gdufs.finalexam.service;

import java.util.Map;

public interface ConfigService {

    /**
     * 修改配置项。
     * 根据配置项名称和新值，更新系统的配置信息，适用于修改某些全局配置。
     *
     * @param configName 配置项的名称
     * @param configValue 配置项的新值
     * @return 返回更新操作影响的行数，通常是 1 表示成功，0 表示失败
     */
    int updateConfig(String configName, String configValue);

    /**
     * 获取所有的配置项。
     * 查询并返回系统中所有配置项的键值对，适用于展示所有当前的配置信息。
     *
     * @return 返回一个 Map，键为配置项名称，值为对应的配置值
     */
    Map<String, String> getAllConfigs();
}
