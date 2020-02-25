package com.easy.infra.biz.user;

import com.easy.infra.dto.RoleAuthority;
import com.easy.infra.dto.UserRole;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户角色业务接口
 * @Date 2020-02-19
 **/
public interface UserRoleBiz {
    /**
     * 保存或更新用户角色信息
     *
     * @param userRoleList
     */
    void saveOrUpdate(List<UserRole> userRoleList);

    /**
     * 批量删除用户角色信息
     *
     * @param userIds
     */
    void deleteByUserIds(List<Long> userIds, Long updateUserId);

    /**
     * 根据用户id集合查询用户角色信息
     *
     * @param userIds
     * @return
     */
    List<UserRole> findByUserIds(List<Long> userIds);
}
