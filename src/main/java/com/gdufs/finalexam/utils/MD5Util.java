package com.gdufs.finalexam.utils;

import java.security.MessageDigest;

/**
 * @description MD5 加密工具类
 * 该类提供了基于 MD5 算法对字符串进行加密的功能，常用于生成数据的哈希值或用于密码加密存储。
 */
public class MD5Util {

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param b 输入的字节数组
     * @return 返回转换后的十六进制字符串
     */
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
        return resultSb.toString();
    }

    /**
     * 将一个字节转换为十六进制字符串
     *
     * @param b 输入的字节
     * @return 返回转换后的十六进制字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 对输入的字符串进行 MD5 加密
     *
     * @param origin 输入的原始字符串
     * @param charsetName 字符集名称（如 UTF-8），用于指定字符串编码
     * @return 返回加密后的 MD5 值
     */
    public static String MD5Encode(String origin, String charsetName) {
        String resultString = null;
        try {
            resultString = new String(origin);
            // 获取 MD5 加密实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 如果字符集为空，使用默认字符集进行编码，否则使用指定的字符集
            if (charsetName == null || "".equals(charsetName))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }

    // 定义十六进制字符数组，用于将字节转换为十六进制表示
    private static final String hexDigits[] =
            {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
            };
}
