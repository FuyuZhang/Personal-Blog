package com.gdufs.finalexam.utils;

import java.io.Serializable;

/**
 * @description 通用的结果类，用于统一封装操作结果
 * @param <T> 泛型，表示返回的数据类型
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 返回结果码
    private int resultCode;

    // 返回消息
    private String message;

    // 返回数据
    private T data;

    /**
     * 默认构造函数
     */
    public Result() {
    }

    /**
     * 构造函数，用于设置结果码和消息
     * @param resultCode 返回的状态码
     * @param message 返回的消息
     */
    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    /**
     * 获取返回的结果码
     * @return 返回的状态码
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * 设置返回的结果码
     * @param resultCode 状态码
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 获取返回的消息
     * @return 返回的消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置返回的消息
     * @param message 消息内容
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取返回的数据
     * @return 返回的数据对象
     */
    public T getData() {
        return data;
    }

    /**
     * 设置返回的数据
     * @param data 数据内容
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 重写toString方法，打印Result对象时显示详细信息
     * @return Result对象的字符串表示
     */
    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
