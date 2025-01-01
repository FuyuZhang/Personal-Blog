package com.gdufs.finalexam.utils;

import org.springframework.util.StringUtils;

/**
 * @description 结果生成器类，提供统一的方法来生成成功或失败的响应结果
 */
public class ResultGenerator {

    // 默认成功的消息
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    // 默认失败的消息
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    // 成功的状态码
    private static final int RESULT_CODE_SUCCESS = 200;

    // 服务器错误的状态码
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    /**
     * 生成一个成功的结果（无数据）
     * @return 成功的结果对象
     */
    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 生成一个成功的结果（带自定义消息）
     * @param message 自定义的成功消息
     * @return 成功的结果对象
     */
    public static Result genSuccessResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

    /**
     * 生成一个成功的结果（带数据）
     * @param data 返回的数据
     * @return 成功的结果对象
     */
    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    /**
     * 生成一个失败的结果（带自定义消息）
     * @param message 自定义的失败消息
     * @return 失败的结果对象
     */
    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        // 如果消息为空，则使用默认失败消息
        if (!StringUtils.hasText(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    /**
     * 生成一个错误的结果（带自定义错误码和消息）
     * @param code 错误码
     * @param message 错误消息
     * @return 错误的结果对象
     */
    public static Result genErrorResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
