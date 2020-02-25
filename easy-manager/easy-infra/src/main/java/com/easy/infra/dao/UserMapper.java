package com.easy.infra.dao;

import com.easy.infra.bo.UserListQueryBo;
import com.easy.infra.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 保存数据
     */
    int insert(User record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(User record);

    /**
     * 通过条件查询数据信息
     */
    List<User> select(User record);

    /**
     * 通过条件查询唯一数据信息
     */
    User selectOne(User record);

    /**
     * 根据主键id批量删除角色
     *
     * @param ids
     * @param updateUserId
     */
    void deleteByPkIds(@Param(value = "ids") List<Long> ids, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 批量更新用户状态
     *
     * @param ids
     * @param status
     * @param updateUserId
     */
    void updateUserStatus(@Param(value = "ids") List<Long> ids, @Param(value = "status") Integer status, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 查询用户列表
     *
     * @param queryBo
     * @return
     */
    List<User> selectUserList(UserListQueryBo queryBo);

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    User selectByUserName(@Param(value = "userName") String userName);
}