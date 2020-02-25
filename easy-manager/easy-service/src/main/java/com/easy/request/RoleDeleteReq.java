package com.easy.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author rzq
 * @Desc 角色删除请求
 * @Date 2020-02-19
 **/
@Data
@ToString
public class RoleDeleteReq implements Serializable {
    /**
     * 操作人id
     */
    private Long updateUserId;
    /**
     * 角色id
     */
    private Long roleId;
}
