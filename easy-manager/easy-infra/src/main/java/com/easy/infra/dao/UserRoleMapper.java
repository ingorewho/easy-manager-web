package com.easy.infra.dao;

import com.easy.infra.dto.RoleAuthority;
import com.easy.infra.dto.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    /**
     * 保存数据
     */
    int insert(UserRole record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(UserRole record);

    /**
     * 通过条件查询数据信息
     */
    List<UserRole> select(UserRole record);

    /**
     * 通过条件查询唯一数据信息
     */
    UserRole selectOne(UserRole record);

    /**
     * 批量插入或更新（根据唯一索引）
     *
     * @param userRoleList
     */
    void batchInsertOrUpdate(@Param(value = "userRoleList") List<UserRole> userRoleList);

    /**
     * 根据角色id集合批量删除角色权限信息
     *
     * @param userIds
     * @param updateUserId
     */
    void deleteByUserIds(@Param(value = "userIds") List<Long> userIds, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 根据用户ids查询用户角色列表
     *
     * @param userIds
     * @return
     */
    List<UserRole> selectByUserIds(@Param(value = "userIds") List<Long> userIds);
}