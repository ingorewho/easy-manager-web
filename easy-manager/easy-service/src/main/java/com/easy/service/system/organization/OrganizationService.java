package com.easy.service.system.organization;

import com.easy.request.OrganizationSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.OrganizationTreeVo;

/**
 * @Author rzq
 * @Desc 组织结构服务接口
 * @Date 2020-02-18
 **/
public interface OrganizationService {
    /**
     * 组织结构提交请求：保存/修改
     *
     * @param submitReq
     * @return
     */
    ApiResponse submit(OrganizationSubmitReq submitReq);

    /**
     * 根据组织id删除对应的组织节点及子节点
     *
     * @param organizationId
     * @return
     */
    ApiResponse delete(Long organizationId);

    /**
     * 查询组织结构树
     *
     * @return
     */
    ApiResponse<OrganizationTreeVo> findOrganizationTree();
}
