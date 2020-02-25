package com.easy.service.system.role.impl;

import com.easy.service.system.role.RoleService;
import com.easy.service.system.role.transfer.RoleParamTransfer;
import com.easy.service.system.role.transfer.RoleVoBuilder;
import com.easy.infra.biz.role.RoleAuthorityBiz;
import com.easy.infra.biz.role.RoleBiz;
import com.easy.infra.dto.Role;
import com.easy.infra.dto.RoleAuthority;
import com.easy.request.RoleDeleteReq;
import com.easy.request.RoleListQueryReq;
import com.easy.request.RoleSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.RoleListVo;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rzq
 * @Desc 角色服务接口实现类
 * @Date 2020-02-19
 **/
@Service
public class RoleServiceImpl implements RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleParamTransfer transfer;
    @Autowired
    private RoleVoBuilder builder;
    @Autowired
    private RoleBiz roleBiz;
    @Autowired
    private RoleAuthorityBiz roleAuthorityBiz;

    @Override
    public ApiResponse submit(RoleSubmitReq submitReq) {
        try {
            Role role = transfer.transferRole(submitReq);
            List<RoleAuthority> roleAuthorityList = transfer.transferRoleAuthorityList(submitReq);
            roleBiz.saveOrUpdate(role);
            roleAuthorityBiz.saveOrUpdate(roleAuthorityList);
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("RoleServiceImpl submit occur exception, submitReq:{}", submitReq, ex);
            return ApiResponse.buildBusExResponse("RoleServiceImpl submit occur exception");
        }
    }

    @Override
    public ApiResponse delete(RoleDeleteReq deleteReq) {
        try {
            roleBiz.deleteByIds(Lists.newArrayList(deleteReq.getRoleId()), deleteReq.getUpdateUserId());
            roleAuthorityBiz.deleteByRoleIds(Lists.newArrayList(deleteReq.getRoleId()), deleteReq.getUpdateUserId());
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("RoleServiceImpl delete occur exception, submitReq:{}", deleteReq, ex);
            return ApiResponse.buildBusExResponse("RoleServiceImpl delete occur exception");
        }
    }

    @Override
    public ApiResponse<List<RoleListVo>> findRoleList(RoleListQueryReq queryReq) {
        try {
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("RoleServiceImpl findRoleList occur exception, submitReq:{}", queryReq, ex);
            return ApiResponse.buildBusExResponse("RoleServiceImpl findRoleList occur exception");
        }
    }
}
