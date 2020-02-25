package com.easy.service.system.organization.impl;

import com.easy.service.system.organization.OrganizationService;
import com.easy.service.system.organization.transfer.OrganizationParamTransfer;
import com.easy.service.system.organization.transfer.OrganizationVoBuilder;
import com.easy.infra.biz.organization.OrganizationBiz;
import com.easy.infra.dto.Organization;
import com.easy.request.OrganizationSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.OrganizationTreeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author rzq
 * @Desc 组织服务接口实现
 * @Date 2020-02-18
 **/
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Autowired
    private OrganizationBiz organizationBiz;
    @Autowired
    private OrganizationParamTransfer transfer;
    @Autowired
    private OrganizationVoBuilder builder;

    @Override
    public ApiResponse submit(OrganizationSubmitReq submitReq) {
        try {
            Organization organization = transfer.transferOrganization(submitReq);
            organizationBiz.saveOrUpdate(organization);
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("OrganizationServiceImpl submit occur exception, submitReq:{}", submitReq, ex);
            return ApiResponse.buildBusExResponse("OrganizationServiceImpl submit occur exception");
        }
    }

    @Override
    public ApiResponse delete(Long organizationId) {
        try {
            organizationBiz.deleteById(organizationId,  null);
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("OrganizationServiceImpl delete occur exception, organizationId:{}", organizationId, ex);
            return ApiResponse.buildBusExResponse("OrganizationServiceImpl delete occur exception");
        }
    }

    @Override
    public ApiResponse<OrganizationTreeVo> findOrganizationTree() {
        return null;
    }
}
