package com.gdufs.finalexam.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @description 正则工具类
 * 该类包含了常用的正则表达式方法，用于验证邮箱、网址和字符类型等。
 */
public class PatternUtil {

    /**
     * 匹配邮箱的正则表达式
     * 用于验证邮箱地址的格式是否符合常见的邮箱标准
     */
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    /**
     * 验证是否只包含中英文和数字的字符串
     * @param keyword 需要验证的字符串
     * @return 如果字符串仅包含中英文字符和数字，返回true；否则返回false
     */
    public static Boolean validKeyword(String keyword) {
        String regex = "^[a-zA-Z0-9\u4E00-\u9FA5]+$"; // 正则表达式：只包含字母、数字和中文字符
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(keyword);
        return match.matches();
    }


    /**
     * 判断字符串是否是有效的邮箱地址
     * @param emailStr 待验证的邮箱字符串
     * @return 如果是有效的邮箱地址，返回true；否则返回false
     */
    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


    /**
     * 判断字符串是否是有效的网址
     * @param urlString 待验证的网址字符串
     * @return 如果是有效的网址，返回true；否则返回false
     */
    public static boolean isURL(String urlString) {
        String regex = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)" +
                "(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})" +
                "([A-Za-z0-9-~]*)\\&{0,1})*)$"; // URL 正则表达式
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(urlString).matches();
    }

}
