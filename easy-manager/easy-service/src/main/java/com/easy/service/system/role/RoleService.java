package com.easy.service.system.role;

import com.easy.request.RoleDeleteReq;
import com.easy.request.RoleListQueryReq;
import com.easy.request.RoleSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.RoleListVo;

import java.util.List;

/**
 * @Author rzq
 * @Desc 角色服务接口
 * @Date 2020-02-19
 **/
public interface RoleService {
    /**
     * 角色信息提交：保存/修改
     *
     * @param submitReq
     * @return
     */
    ApiResponse submit(RoleSubmitReq submitReq);

    /**
     * 角色删除请求
     *
     * @param deleteReq
     * @return
     */
    ApiResponse delete(RoleDeleteReq deleteReq);

    /**
     * 查询角色列表
     *
     * @param queryReq
     * @return
     */
    ApiResponse<List<RoleListVo>> findRoleList(RoleListQueryReq queryReq);
}
