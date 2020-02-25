package com.easy.service.system.role.transfer;

import com.easy.infra.dto.Role;
import com.easy.infra.dto.RoleAuthority;
import com.easy.request.RoleSubmitReq;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author rzq
 * @Desc 角色请求参数转换
 * @Date 2020-02-19
 **/
@Component
public class RoleParamTransfer {

    /**
     * 转换角色请求信息
     *
     * @param submitReq
     * @return
     */
    public Role transferRole(RoleSubmitReq submitReq) {
        return null;
    }

    /**
     * 转换角色权限请求信息
     *
     * @param submitReq
     * @return
     */
    public List<RoleAuthority> transferRoleAuthorityList(RoleSubmitReq submitReq) {
        return Lists.newArrayList();
    }
}
