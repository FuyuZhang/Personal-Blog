package com.gdufs.finalexam.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description 分页查询参数工具类
 * 该类用于封装分页查询的相关参数，并为分页查询提供分页信息计算功能。
 */
public class PageQueryUtil extends LinkedHashMap<String, Object> {
    // 当前页码
    private int page;
    // 每页条数
    private int limit;

    /**
     * 构造函数，根据传入的参数初始化分页查询信息
     *
     * @param params 包含分页查询所需参数的 Map 对象，必须包含 "page" 和 "limit" 键
     */
    public PageQueryUtil(Map<String, Object> params) {
        // 将传入的所有参数存入当前对象
        this.putAll(params);
        // 获取当前页码，并将其转换为整数
        this.page = Integer.parseInt(params.get("page").toString());
        // 获取每页条数，并将其转换为整数
        this.limit = Integer.parseInt(params.get("limit").toString());
        // 计算查询的起始位置，便于数据库查询
        this.put("start", (page - 1) * limit);
        // 将分页信息（页码和每页条数）存入当前对象
        this.put("page", page);
        this.put("limit", limit);
    }

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置当前页码
     *
     * @param page 要设置的页码
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 获取每页条数
     *
     * @return 每页条数
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 设置每页条数
     *
     * @param limit 每页条数
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * 重写 toString 方法，输出分页信息
     *
     * @return 分页信息的字符串表示
     */
    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
