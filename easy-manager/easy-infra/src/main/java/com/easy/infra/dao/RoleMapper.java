package com.easy.infra.dao;

import com.easy.infra.bo.RoleListQueryBo;
import com.easy.infra.dto.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * 保存数据
     */
    int insert(Role record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(Role record);

    /**
     * 通过条件查询数据信息
     */
    List<Role> select(Role record);

    /**
     * 通过条件查询唯一数据信息
     */
    Role selectOne(Role record);

    /**
     * 根据主键id批量删除角色
     *
     * @param ids
     * @param updateUserId
     */
    void deleteByPkIds(@Param(value = "ids") List<Long> ids, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 批量更新角色状态
     *
     * @param ids
     * @param status
     * @param updateUserId
     */
    void updateRoleStatus(@Param(value = "ids") List<Long> ids, @Param(value = "status") Integer status, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 查询角色列表
     *
     * @param queryBo
     * @return
     */
    List<Role> selectRoleList(RoleListQueryBo queryBo);
}