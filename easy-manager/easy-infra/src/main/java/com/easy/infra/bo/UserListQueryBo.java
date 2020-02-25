package com.easy.infra.bo;

import lombok.Data;

/**
 * @Author rzq
 * @Desc 用户列表查询BO
 * @Date 2020-02-19
 **/
@Data
public class UserListQueryBo {
    /**
     * 用户名称
     */
    private String userName;

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
