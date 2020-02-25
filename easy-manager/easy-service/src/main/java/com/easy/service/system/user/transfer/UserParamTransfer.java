package com.easy.service.system.user.transfer;

import com.easy.infra.bo.UserListQueryBo;
import com.easy.infra.dto.User;
import com.easy.infra.dto.UserRole;
import com.easy.request.UserListQueryReq;
import com.easy.request.UserSubmitReq;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户请求参数转换器
 * @Date 2020-02-20
 **/
@Component
public class UserParamTransfer {

    /**
     * 转换用户请求信息为用户实体
     *
     * @param submitReq
     * @return
     */
    public User transferUser(UserSubmitReq submitReq) {
        return null;
    }

    /**
     * 转换用户请求信息为用户角色实体
     *
     * @param submitReq
     * @return
     */
    public List<UserRole> transferUserRoleList(UserSubmitReq submitReq) {
        return Lists.newArrayList();
    }

    /**
     * 转换用户请求信息为请求BO
     *
     * @param queryReq
     * @return
     */
    public UserListQueryBo transferUserListQueryBo(UserListQueryReq queryReq) {
        return null;
    }
}
