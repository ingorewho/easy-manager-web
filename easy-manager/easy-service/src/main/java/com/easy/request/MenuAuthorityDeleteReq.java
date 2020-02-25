package com.easy.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author rzq
 * @Desc 功能权限删除请求
 * @Date 2020-02-18
 **/
@Data
public class MenuAuthorityDeleteReq implements Serializable {
    /**
     * 功能权限id
     */
    private Long menuAuthorityId;
    /**
     * 更新用户id
     */
    private Long updateUserId;
}
