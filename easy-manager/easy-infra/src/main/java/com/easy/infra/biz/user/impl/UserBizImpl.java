package com.easy.infra.biz.user.impl;

import com.easy.infra.biz.user.UserBiz;
import com.easy.infra.bo.UserListQueryBo;
import com.easy.infra.dao.UserMapper;
import com.easy.infra.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author rzq
 * @Desc 用户业务接口
 * @Date 2020-02-19
 **/
@Slf4j
@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveOrUpdate(User user) {
        if (Objects.nonNull(user.getId())) {
            userMapper.update(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteByIds(List<Long> userIds, Long updateUserId) {
        if (CollectionUtils.isEmpty(userIds)) {
            log.warn("UserBizImpl deleteByIds userIds isEmpty!");
            return;
        }
        userMapper.deleteByPkIds(userIds, updateUserId);
    }

    @Override
    public void updateUserStatus(List<Long> userIds, Integer status, Long updateUserId) {
        if (CollectionUtils.isEmpty(userIds)) {
            log.warn("UserBizImpl updateUserStatus userIds isEmpty!");
            return;
        }
        userMapper.updateUserStatus(userIds, status, updateUserId);
    }

    @Override
    public List<User> findUserByQueryBo(UserListQueryBo queryBo) {
        if (Objects.isNull(queryBo)) {
            log.warn("UserBizImpl findUserByQueryBo queryBo isNull!");
            return Lists.newArrayList();
        }
        return userMapper.selectUserList(queryBo);
    }

    @Override
    public User findByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            log.warn("UserBizImpl findByUserName userName isEmpty!");
            return null;
        }
        return userMapper.selectByUserName(userName);
    }
}
