package com.zsc.common.domain;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author : xingpeng
 * @date : 2021-12-09 12:55
 **/
public class ApiResult implements Serializable {
    private static final long serialVersionUID = -1576419335624861702L;

    private int code = 0;

    private String message;

    public ApiResult() {}

    /**
     * 构造方法
     *
     * @param code 返回代码
     * @param message 返回错误消息
     */
    public  ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造方法
     *
     * @param ex 异常对象
     * @param message 返回错误消息
     */
    public ApiResult(Exception ex, String message) {
        this.message = message;
    }

    /**
     * 构造一个失败结果
     *
     * @param code 返回代码
     * @param message 返回错误消息
     * @return ApiResult 结果对象
     */
    public static ApiResult failResult(int code, String message) {
        Assert.isTrue(code > 0, "失败结果不能设置code为0");

        return new ApiResult(code, message);
    }

    /**
     * 通过异常数据构造一个失败结果
     *
     * @param ex 错误对象
     * @param message 错误消息
     * @return ApiResult 结果对象
     */
//    public static ApiResult failResult(Exception ex, String message) {
//        Assert.notNull(ex, "参数不允许为空");
//        return new ApiResult(code, message);
//    }

    /**
     * 构造一个成功结果
     *
     * @return ApiResult
     */
    public static ApiResult successResult() {
        return new ApiResult(0, "成功");
    }

    /**
     * 结果是否为成功
     *
     * @param result
     * @return boolean 表示是否成功
     */
    public static boolean isSuccess(ApiResult result) {
        return result.code == 0;
    }

}
