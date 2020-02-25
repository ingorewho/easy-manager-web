package com.easy.infra.biz.role;

import com.easy.infra.dto.Role;
import com.easy.infra.dto.RoleAuthority;

import java.util.List;

/**
 * @Author rzq
 * @Desc 角色权限业务接口
 * @Date 2020-02-19
 **/
public interface RoleAuthorityBiz {
    /**
     * 保存或更新角色权限信息
     *
     * @param roleAuthorityList
     */
    void saveOrUpdate(List<RoleAuthority> roleAuthorityList);

    /**
     * 批量删除角色权限信息
     *
     * @param roleIds
     */
    void deleteByRoleIds(List<Long> roleIds, Long updateUserId);
}
