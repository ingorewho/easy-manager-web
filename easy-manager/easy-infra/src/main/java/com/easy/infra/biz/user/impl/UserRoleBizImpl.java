package com.easy.infra.biz.user.impl;

import com.easy.infra.biz.user.UserRoleBiz;
import com.easy.infra.dao.UserRoleMapper;
import com.easy.infra.dto.UserRole;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户角色业务接口实现类
 * @Date 2020-02-19
 **/
@Service
public class UserRoleBizImpl implements UserRoleBiz {
    private Logger logger = LoggerFactory.getLogger(UserRoleBizImpl.class);

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void saveOrUpdate(List<UserRole> userRoleList) {
        if (CollectionUtils.isEmpty(userRoleList)) {
            logger.warn("UserRoleBizImpl saveOrUpdate userRoleList isEmpty!");
            return;
        }
        userRoleMapper.batchInsertOrUpdate(userRoleList);
    }

    @Override
    public void deleteByUserIds(List<Long> userIds, Long updateUserId) {
        if (CollectionUtils.isEmpty(userIds)) {
            logger.warn("UserRoleBizImpl deleteByUserIds userIds isEmpty!");
            return;
        }
        userRoleMapper.deleteByUserIds(userIds, updateUserId);
    }

    @Override
    public List<UserRole> findByUserIds(List<Long> userIds) {
        if(CollectionUtils.isEmpty(userIds)) {
            logger.warn("UserRoleBizImpl findByUserIds userIds isEmpty!");
            return Lists.newArrayList();
        }

        return userRoleMapper.selectByUserIds(userIds);
    }
}
