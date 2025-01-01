package com.gdufs.finalexam.service;

import com.gdufs.finalexam.entity.AdminUser;

public interface AdminUserService {

    /**
     * 登录方法，使用用户名和密码进行身份验证。
     * 如果登录成功，返回对应的用户信息。
     *
     * @param userName 用户名
     * @param password 密码
     * @return 登录成功的用户信息，如果用户名或密码错误，返回 null
     */
    AdminUser login(String userName, String password);

    /**
     * 获取指定用户 ID 的详细信息。
     * 返回一个包含用户详细信息的 `AdminUser` 对象。
     *
     * @param loginUserId 当前登录用户的 ID
     * @return 返回 `AdminUser` 对象，包含该用户的详细信息
     */
    AdminUser getUserDetailById(Integer loginUserId);

    /**
     * 修改当前登录用户的密码。
     * 如果原密码正确，则更新为新密码。
     *
     * @param loginUserId 当前登录用户的 ID
     * @param originalPassword 用户输入的原密码
     * @param newPassword 用户输入的新密码
     * @return 如果修改成功，返回 true；否则返回 false
     */
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息。
     * 允许用户修改登录用户名和昵称。
     *
     * @param loginUserId 当前登录用户的 ID
     * @param loginUserName 用户新的登录用户名
     * @param nickName 用户新的昵称
     * @return 如果修改成功，返回 true；否则返回 false
     */
    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);
}
