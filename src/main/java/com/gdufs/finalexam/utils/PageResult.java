package com.gdufs.finalexam.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @description 分页工具类
 * 该类用于封装分页查询的结果，包括总记录数、每页记录数、总页数、当前页数和当前页的数据列表。
 */
public class PageResult implements Serializable {

    // 总记录数
    private int totalCount;
    // 每页记录数
    private int pageSize;
    // 总页数
    private int totalPage;
    // 当前页数
    private int currPage;
    // 列表数据
    private List<?> list;

    /**
     * 构造函数，初始化分页查询结果
     *
     * @param list       当前页的数据列表
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageResult(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        // 计算总页数，总页数 = 总记录数 / 每页记录数（向上取整）
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    /**
     * 获取总记录数
     *
     * @return 总记录数
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数
     *
     * @param totalCount 总记录数
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取每页记录数
     *
     * @return 每页记录数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页记录数
     *
     * @param pageSize 每页记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 设置总页数
     *
     * @param totalPage 总页数
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取当前页数
     *
     * @return 当前页数
     */
    public int getCurrPage() {
        return currPage;
    }

    /**
     * 设置当前页数
     *
     * @param currPage 当前页数
     */
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    /**
     * 获取当前页的数据列表
     *
     * @return 当前页的数据列表
     */
    public List<?> getList() {
        return list;
    }

    /**
     * 设置当前页的数据列表
     *
     * @param list 当前页的数据列表
     */
    public void setList(List<?> list) {
        this.list = list;
    }

}
