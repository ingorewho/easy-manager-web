package com.easy.service.system.organization.transfer;

import com.easy.infra.dto.Organization;
import com.easy.response.vo.OrganizationTreeVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author rzq
 * @Desc Organization构建器
 * @Date 2020-02-19
 **/
@Component
public class OrganizationVoBuilder {

    /**
     * 构建组织树
     *
     * @param organizations
     * @return
     */
    public OrganizationTreeVo buildOrganizationTree(List<Organization> organizations) {
        return null;
    }
}
