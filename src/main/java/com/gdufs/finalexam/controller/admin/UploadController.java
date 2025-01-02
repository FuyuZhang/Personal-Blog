package com.gdufs.finalexam.controller.admin;

import com.gdufs.finalexam.config.Constants;
import com.gdufs.finalexam.utils.MyBlogUtil;
import com.gdufs.finalexam.utils.Result;
import com.gdufs.finalexam.utils.ResultGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 文件上传控制器，处理文件上传操作。
 */
@Controller
@RequestMapping("/admin")
public class UploadController {

    /**
     * 处理文件上传
     */
    @PostMapping({"/upload/file"})
    @ResponseBody
    public Result upload(HttpServletRequest httpServletRequest,
                         @RequestParam("file") MultipartFile file) throws URISyntaxException {
        String fileName = file.getOriginalFilename(); // 获取上传文件的原始文件名
        String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀名
        // 生成文件名称通用方法，包含日期和随机数
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName); // 生成新的文件名
        String newFileName = tempName.toString();

        // 获取文件存储目录
        File fileDirectory = new File(Constants.FILE_UPLOAD_DIC);
        // 创建目标文件
        File destFile = new File(Constants.FILE_UPLOAD_DIC + newFileName);
        try {
            // 如果目录不存在，则创建目录
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory); // 创建失败抛出异常
                }
            }
            // 将上传的文件保存到指定目录
            file.transferTo(destFile);

            // 成功返回上传后的文件路径
            Result resultSuccess = ResultGenerator.genSuccessResult();
            // 设置返回的数据为上传后的文件访问路径
            resultSuccess.setData(MyBlogUtil.getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
            return resultSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("文件上传失败"); // 上传失败返回错误信息
        }
    }
}