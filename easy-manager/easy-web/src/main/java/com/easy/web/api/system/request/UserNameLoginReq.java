package com.easy.web.api.system.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author rzq
 * @Desc 用户登录请求
 * @Date 2020-02-21
 **/
@Data
@ToString
public class UserNameLoginReq implements Serializable {
    private static final long serialVersionUID = -7817247601160795131L;
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String userName;
    @ApiModelProperty(value = "密码", dataType = "String")
    private String passWord;
}
