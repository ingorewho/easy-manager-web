package com.easy.infra.dao;

import com.easy.infra.dto.RoleAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthorityMapper {
    /**
     * 保存数据
     */
    int insert(RoleAuthority record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(RoleAuthority record);

    /**
     * 通过条件查询数据信息
     */
    List<RoleAuthority> select(RoleAuthority record);

    /**
     * 通过条件查询唯一数据信息
     */
    RoleAuthority selectOne(RoleAuthority record);

    /**
     * 批量插入或更新（根据唯一索引）
     *
     * @param roleAuthorityList
     */
    void batchInsertOrUpdate(@Param(value = "roleAuthorityList") List<RoleAuthority> roleAuthorityList);

    /**
     * 根据角色id集合批量删除角色权限信息
     *
     * @param roleIds
     * @param updateUserId
     */
    void deleteByRoleIds(@Param(value = "roleIds") List<Long> roleIds, @Param(value = "updateUserId") Long updateUserId);
}