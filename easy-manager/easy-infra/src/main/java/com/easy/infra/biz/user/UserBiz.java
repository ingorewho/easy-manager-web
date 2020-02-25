package com.easy.infra.biz.user;

import com.easy.infra.bo.UserListQueryBo;
import com.easy.infra.dto.User;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户业务接口
 * @Date 2020-02-19
 **/
public interface UserBiz {
    /**
     * 保存或更新用户信息
     *
     * @param user
     */
    void saveOrUpdate(User user);

    /**
     * 批量删除角色信息
     *
     * @param userIds
     */
    void deleteByIds(List<Long> userIds, Long updateUserId);

    /**
     * 批量更新角色状态
     *
     * @param userIds
     * @param status
     */
    void updateUserStatus(List<Long> userIds, Integer status, Long updateUserId);

    /**
     * 根据条件查询用户列表
     *
     * @param queryBo
     * @return
     */
    List<User> findUserByQueryBo(UserListQueryBo queryBo);

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
