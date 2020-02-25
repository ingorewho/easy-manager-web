package com.easy.infra.biz.role;

import com.easy.infra.bo.RoleListQueryBo;
import com.easy.infra.dto.Goods;
import com.easy.infra.dto.Role;

import java.util.List;

/**
 * @Author rzq
 * @Desc 角色业务接口
 * @Date 2020-02-19
 **/
public interface RoleBiz {
    /**
     * 保存或更新商品
     *
     * @param role
     */
    void saveOrUpdate(Role role);

    /**
     * 批量删除角色信息
     *
     * @param roleIds
     */
    void deleteByIds(List<Long> roleIds, Long updateUserId);

    /**
     * 批量更新角色状态
     *
     * @param roleIds
     * @param status
     */
    void updateRoleStatus(List<Long> roleIds, Integer status, Long updateUserId);

    /**
     * 根据条件查询角色列表
     *
     * @param queryBo
     * @return
     */
    List<Role> findRoleByQueryBo(RoleListQueryBo queryBo);
}
