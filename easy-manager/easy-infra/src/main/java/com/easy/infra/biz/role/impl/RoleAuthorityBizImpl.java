package com.easy.infra.biz.role.impl;

import com.easy.infra.biz.role.RoleAuthorityBiz;
import com.easy.infra.dao.RoleAuthorityMapper;
import com.easy.infra.dto.RoleAuthority;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rzq
 * @Desc 角色权限业务接口实现类
 * @Date 2020-02-19
 **/
@Service
public class RoleAuthorityBizImpl implements RoleAuthorityBiz {
    private Logger logger = LoggerFactory.getLogger(RoleAuthorityBizImpl.class);

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public void saveOrUpdate(List<RoleAuthority> roleAuthorityList) {
        if (CollectionUtils.isEmpty(roleAuthorityList)) {
            logger.warn("RoleAuthorityBizImpl saveOrUpdate roleAuthorityList isEmpty!");
            return;
        }
        roleAuthorityMapper.batchInsertOrUpdate(roleAuthorityList);
    }

    @Override
    public void deleteByRoleIds(List<Long> roleIds, Long updateUserId) {
        if (CollectionUtils.isEmpty(roleIds)) {
            logger.warn("RoleAuthorityBizImpl deleteByRoleIds roleIds isEmpty!");
            return;
        }
        roleAuthorityMapper.deleteByRoleIds(roleIds, updateUserId);
    }
}
