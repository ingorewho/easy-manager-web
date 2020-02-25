package com.easy.response;

/**
 * @Author rzq
 * @Desc Api错误枚举
 * @Date 2019-04-09
 **/
public enum ApiCode {
    /**
     * 成功返回码
     */
    CODE_SUCCESS(200),

    /**
     * 失败错误码
     */
    CODE_FAIL(201),

    /**
     * 返回内容为空
     */
    CODE_CONTENT_EMPTY(204),

    /**
     * 访问被拒绝
     */
    CODE_REJECT(403),

    /**
     * 业务异常
     */
    CODE_BUSINESS_EXCEPTION(5001),

    /**
     * 系统异常
     */
    CODE_SYSTEM_EXCEPTION(5002),

    /**
     * 参数校验异常
     */
    CODE_VALIDATE_EXCEPTION(5003);


    private ApiCode(int intCode) {
        this.code = intCode;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public static ApiCode getApiCode(int code){
        for (ApiCode apiCode : ApiCode.values()){
            if (apiCode.code == code){
                return apiCode;
            }
        }
        //如果没找到对应code，返回fail_code
        return CODE_FAIL;
    }
}
