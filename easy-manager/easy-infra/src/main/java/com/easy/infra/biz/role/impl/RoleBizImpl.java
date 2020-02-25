package com.easy.infra.biz.role.impl;

import com.easy.infra.biz.role.RoleBiz;
import com.easy.infra.bo.RoleListQueryBo;
import com.easy.infra.dao.RoleMapper;
import com.easy.infra.dto.Role;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author rzq
 * @Desc 角色业务接口实现类
 * @Date 2020-02-19
 **/
@Service
public class RoleBizImpl implements RoleBiz {
    private Logger logger = LoggerFactory.getLogger(RoleBizImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void saveOrUpdate(Role role) {
        if (Objects.nonNull(role.getId())) {
            roleMapper.update(role);
        } else {
            roleMapper.insert(role);
        }
    }

    @Override
    public void deleteByIds(List<Long> roleIds, Long updateUserId) {
        if (CollectionUtils.isEmpty(roleIds)) {
            logger.warn("RoleBizImpl deleteByIds roleIds isEmpty!");
            return;
        }
        roleMapper.deleteByPkIds(roleIds, updateUserId);
    }

    @Override
    public void updateRoleStatus(List<Long> roleIds, Integer status, Long updateUserId) {
        if (CollectionUtils.isEmpty(roleIds)) {
            logger.warn("RoleBizImpl updateRoleStatus roleIds isEmpty!");
            return;
        }
        roleMapper.updateRoleStatus(roleIds, status, updateUserId);
    }

    @Override
    public List<Role> findRoleByQueryBo(RoleListQueryBo queryBo) {
        if (Objects.isNull(queryBo)) {
            logger.warn("RoleBizImpl findRoleByQueryBo queryBo isNull!");
            return Lists.newArrayList();
        }
        return roleMapper.selectRoleList(queryBo);
    }
}
