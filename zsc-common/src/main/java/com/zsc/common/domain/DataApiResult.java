package com.zsc.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

/**
 * @author : xingpeng
 * @date : 2021-12-09 15:29
 **/
public class DataApiResult<T> extends ApiResult {

    private static final long serialVersionUID = -5963397321998888554L;

    @Getter
    @Setter
    private T data = null;

    public DataApiResult() {}

    /**
     * 内部构建方法
     *
     * @param code 错误代码
     * @param message 错误消息
     */
    private DataApiResult(int code, String message) {
        super(code, message);
    }

    /**
     * 内部构建方法
     *
     * @param ex 错误对象
     * @param message 错误消息
     */
    private DataApiResult(Exception ex, String message) {
        super(ex, message);
    }

    /**
     * 构造一个失败结果
     *
     * @param code 返回码
     * @param message 返回消息
     * @return ApiResult 结果对象
     */
    public static <K> DataApiResult<K> fail(int code, String message) {

        Assert.isTrue(code > 0, "错误结果请不要设置code值为0");

        return new DataApiResult<K>(code, message);
    }

    /**
     * 构造一个标准错误
     *
     * @param <K> 返回数据类型
     * @param message
     * @return
     */
    public static <K> DataApiResult<K> fail(String message) {
        // return new DataApiResult<K>(XbgExceptionConstant.UnknowErr, message);
        return null;
    }

    /**
     * 通过错误对象设置错误返回码
     *
     * @param <K> 返回的参数类型
     * @param ex 错误对象
     * @param message 错误消息
     * @return DataApiResult
     */
    public static <K> DataApiResult<K> fail(Exception ex, String message) {
        Assert.notNull(ex, "参数ex不允许为空");
        return new DataApiResult<K>(ex, message);
    }


    /**
     * 返回成功结果
     *
     * @param <K> 结果类型
     * @param data 结果数据
     * @return DataApiResult
     */
    public static <K> DataApiResult<K> success(K data) {
        DataApiResult<K> re = new DataApiResult<K>(0, "成功");
        re.setData(data);
        return re;
    }
}
