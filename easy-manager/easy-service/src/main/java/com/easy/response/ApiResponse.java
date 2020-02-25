package com.easy.response;

import java.io.Serializable;

/**
 * @Author rzq
 * @Desc 响应结果
 * @Date 2019-04-09
 **/
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回CODE码，详见{@link ApiCode}中定义
     */
    private int code;

    /**
     * 异常返回message
     */
    private String msg;

    /**
     * 成功返回数据
     */
    private T data;

    private ApiResponse() {

    }

    private ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 请求成功
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ApiResponse<T> buildSuccessResponse(T data){
        ApiResponse<T> response = new ApiResponse<T>();
        response.setCode(ApiCode.CODE_SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    /**
     * 请求失败
     * @param msg
     * @return
     */
    public static ApiResponse buildFailResponse(String msg) {
        ApiResponse response = new ApiResponse();
        response.setCode(ApiCode.CODE_FAIL.getCode());
        response.setMsg(msg);
        return response;
    }

    /**
     * 业务异常
     *
     * @return
     */
    public static ApiResponse buildBusExResponse(String msg) {
        ApiResponse response = new ApiResponse();
        response.setCode(ApiCode.CODE_BUSINESS_EXCEPTION.getCode());
        response.setMsg(msg);
        return response;
    }

    /**
     * 系统异常
     *
     * @return
     */
    public static ApiResponse buildSysExResponse(String msg) {
        ApiResponse response = new ApiResponse();
        response.setCode(ApiCode.CODE_SYSTEM_EXCEPTION.getCode());
        response.setMsg(msg);
        return response;
    }

    /**
     * 参数校验异常
     *
     * @return
     */
    public static ApiResponse buildValidateExResponse(String msg) {
        ApiResponse response = new ApiResponse();
        response.setCode(ApiCode.CODE_VALIDATE_EXCEPTION.getCode());
        response.setMsg(msg);
        return response;
    }

    /**
     * 接入失败较为通用，所以单独写方法
     * @param msg
     * @return
     */
    public static ApiResponse<Object> buildAccessError(String msg) {
        return buildResponse(ApiCode.CODE_REJECT, msg);
    }

    public static ApiResponse<Object> buildResponse(ApiCode code, String msg){
        ApiResponse<Object> response = new ApiResponse<Object>();
        response.setCode(code.getCode());
        response.setMsg(msg);
        return response;
    }

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return ApiCode.CODE_SUCCESS.getCode().equals(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
