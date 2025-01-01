package com.gdufs.finalexam.entity;

import lombok.Data;

/**
 * AdminUser实体类类表示管理员用户（AdminUser）的实体，包含管理员用户的基本信息及相关操作。
 * 该类主要用于系统中的管理员身份验证与管理功能。
 */
@Data
public class AdminUser {
    private Integer adminUserId;  // 管理员用户的唯一标识 ID
    private String loginUserName;  // 管理员用户的登录用户名
    private String loginPassword;  // 管理员用户的登录密码
    private String nickName;  // 管理员用户的昵称
    private Byte locked;  // 账户是否被锁定，1 为锁定，0 为未锁定

    /**
     * 设置登录用户名，去除前后空格
     *
     * @param loginUserName 登录用户名
     */
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }

    /**
     * 设置登录密码，去除前后空格
     *
     * @param loginPassword 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * 设置昵称，去除前后空格
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 重写 toString 方法，输出 AdminUser 对象的详细信息
     *
     * @return AdminUser 对象的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", loginUserName=").append(loginUserName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", nickName=").append(nickName);
        sb.append(", locked=").append(locked);
        sb.append("]");
        return sb.toString();
    }
}
