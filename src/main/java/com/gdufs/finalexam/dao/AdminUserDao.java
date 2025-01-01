package com.gdufs.finalexam.dao;

import com.gdufs.finalexam.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * AdminUserDao 接口
 *
 * 该接口用于处理 AdminUser 实体类的数据访问操作，主要包括对 AdminUser 记录的增、删、改、查等功能。
 * 该接口使用了 MyBatis 框架，定义了与数据库交互的操作方法，支持管理员用户的登录验证、信息更新等功能。
 *
 * 主要方法包括：
 * - 插入新用户记录
 * - 根据用户名和密码进行用户登录验证
 * - 根据主键查询、更新 AdminUser 信息
 */
public interface AdminUserDao {

    /**
     * 插入一条 AdminUser 记录
     *
     * @param record AdminUser 对象
     * @return 插入的记录数
     */
    int insert(AdminUser record);

    /**
     * 插入一条 AdminUser 记录，插入的字段为非空字段
     *
     * @param record AdminUser 对象
     * @return 插入的记录数
     */
    int insertSelective(AdminUser record);

    /**
     * 用户登录方法，传入用户名和密码
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回符合条件的 AdminUser 对象
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据主键查询 AdminUser
     *
     * @param adminUserId 主键 id
     * @return 查询到的 AdminUser 对象
     */
    AdminUser selectByPrimaryKey(Integer adminUserId);

    /**
     * 根据主键更新 AdminUser 的非空字段
     *
     * @param record 更新的 AdminUser 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(AdminUser record);

    /**
     * 根据主键更新 AdminUser 的所有字段
     *
     * @param record 更新的 AdminUser 对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(AdminUser record);
}
