package com.easy.infra.bo;

import lombok.Data;

/**
 * @Author rzq
 * @Desc 角色列表查询BO
 * @Date 2020-02-19
 **/
@Data
public class RoleListQueryBo {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色编码
     */
    private String roleCode;
}
