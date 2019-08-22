package com.house.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * API响应类
 * @author house
 */
@Data
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 6624863815767833913L;
    public static final int NO_LOGIN = -1;
    public static final int SUCCESS = 0;
    public static final int CHECK_FAIL = 1;
    public static final int NO_PERMISSION = 2;
    public static final int UNKNOWN_EXCEPTION = -99;
    /**
     * 返回的信息
     */
    private String msg = "success";
    /**
     * 接口返回码
     * 0: 成功
     * 大于0: 表示已知的异常(例如提示错误等，需要调用地方单独处理)
     * 小于0: 表示未知的异常(不需要单独处理，调用方统一处理)
     */
    private int code = SUCCESS;
    /**
     * 返回的数据
     */
    private T data;

    public ApiResult(){
        super();
    }

    public ApiResult(T data){
        super();
        this.data = data;
    }

    public ApiResult(Throwable e){
        super();
        this.msg = e.getMessage();
        this.code = UNKNOWN_EXCEPTION;
    }
}