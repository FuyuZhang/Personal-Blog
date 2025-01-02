package com.gdufs.finalexam.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 实体类 AdminUser
 * 用于表示管理员用户的基本信息
 */
public class AdminUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer adminUserId;  // 管理员用户的唯一标识 ID
    private String loginUserName;  // 管理员用户的登录用户名
    private String loginPassword;  // 管理员用户的登录密码
    private String nickName;  // 管理员用户的昵称
    private Byte locked;  // 账户是否被锁定，1 为锁定，0 为未锁定

    // 无参构造方法
    public AdminUser() {
    }

    // 全参构造方法
    public AdminUser(Integer adminUserId, String loginUserName, String loginPassword, String nickName, Byte locked) {
        this.adminUserId = adminUserId;
        this.loginUserName = loginUserName;
        this.loginPassword = loginPassword;
        this.nickName = nickName;
        this.locked = locked;
    }

    // Getter 和 Setter 方法
    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
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