package com.easy.infra.biz.organization;

import com.easy.infra.dto.Organization;

import java.util.List;

/**
 * @Author rzq
 * @Desc 组织业务接口
 * @Date 2020-02-18
 **/
public interface OrganizationBiz {
    /**
     * 保存或更新组织节点
     *
     * @param organization
     */
    void saveOrUpdate(Organization organization);

    /**
     * 删除组织节点
     *
     * @param organizationId
     */
    void deleteById(Long organizationId, Long updateUserId);

    /**
     * 查询组织所有节点
     *
     * @return
     */
    List<Organization> findAllOrganizations();
}
