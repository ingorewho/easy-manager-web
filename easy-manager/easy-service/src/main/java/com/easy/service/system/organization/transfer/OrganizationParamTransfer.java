package com.easy.service.system.organization.transfer;

import com.easy.infra.dto.Organization;
import com.easy.request.OrganizationSubmitReq;
import com.easy.util.PropertyCopierUtil;
import org.springframework.stereotype.Component;

/**
 * @Author rzq
 * @Desc 组织请求参数转换
 * @Date 2020-02-19
 **/
@Component
public class OrganizationParamTransfer {

    /**
     * 转换提交请求
     *
     * @param submitReq
     * @return
     */
    public Organization transferOrganization(OrganizationSubmitReq submitReq) {
        return PropertyCopierUtil.copy(submitReq, Organization.class);
    }
}
