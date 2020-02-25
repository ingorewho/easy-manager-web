package com.easy.service.system.user.transfer;

import com.easy.infra.dto.User;
import com.easy.infra.dto.UserRole;
import com.easy.response.vo.UserListVo;
import com.easy.response.vo.UserVo;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户Vo构建器
 * @Date 2020-02-20
 **/
@Component
public class UserVoBuilder {

    /**
     * 构建用户列表Vo
     *
     * @param userList
     * @param userRoleList
     * @return
     */
    public List<UserListVo> buildUserList(List<User> userList, List<UserRole> userRoleList) {
        return Lists.newArrayList();
    }

    /**
     * 构建用户信息
     *
     * @param user
     * @return
     */
    public UserVo buildUser(User user) {
        return null;
    }
}
