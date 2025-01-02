package com.gdufs.finalexam.service.impl;

import com.gdufs.finalexam.dao.AdminUserDao;
import com.gdufs.finalexam.entity.AdminUser;
import com.gdufs.finalexam.service.AdminUserService;
import com.gdufs.finalexam.utils.MD5Util;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserDao.login(userName, passwordMd5);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserDao.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserDao.selectByPrimaryKey(loginUserId);
        // 当前用户非空才可以进行更改
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            // 验证密码是否正确
            if (originalPasswordMd5.equals(adminUser.getLoginPassword())) {
                // 设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                // 修改成功则返回true
                return adminUserDao.updateByPrimaryKeySelective(adminUser) > 0;
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserDao.selectByPrimaryKey(loginUserId);
        // 当前用户非空才可以进行更改
        if (adminUser != null) {
            // 修改信息
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            // 修改成功则返回true
            return adminUserDao.updateByPrimaryKeySelective(adminUser) > 0;
        }
        return false;
    }
}
