package com.easy.response.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author rzq
 * @Desc 用户Vo
 * @Date 2020-02-20
 **/
@Data
@ToString
public class UserVo implements Serializable {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户状态(0-正常 1-冻结)
     */
    private Integer status;

    /**
     * 用户邮箱地址
     */
    private String email;
}
