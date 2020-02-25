package com.easy.service.system.authority.impl;

import com.easy.service.system.authority.AuthorityService;
import com.easy.service.system.authority.transfer.AuthorityParamTransfer;
import com.easy.service.system.authority.transfer.AuthorityVoBuilder;
import com.easy.infra.biz.authority.MenuAuthorityBiz;
import com.easy.infra.dto.MenuAuthority;
import com.easy.request.MenuAuthorityDeleteReq;
import com.easy.request.MenuAuthoritySubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.MenuAuthorityTreeVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rzq
 * @Desc 权限服务接口实现类
 * @Date 2020-02-18
 **/
@Service
public class AuthorityServiceImpl implements AuthorityService {
    private Logger logger = LoggerFactory.getLogger(AuthorityServiceImpl.class);

    @Autowired
    private MenuAuthorityBiz menuAuthorityBiz;
    @Autowired
    private AuthorityParamTransfer transfer;
    @Autowired
    private AuthorityVoBuilder builder;

    @Override
    public ApiResponse submitMenuAuthority(MenuAuthoritySubmitReq submitReq) {
        try {
            MenuAuthority menuAuthority = transfer.transferMenuAuthority(submitReq);
            menuAuthorityBiz.saveOrUpdate(menuAuthority);
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("AuthorityServiceImpl submitMenuAuthority occur exception, submitReq:{}", submitReq, ex);
            return ApiResponse.buildBusExResponse("AuthorityServiceImpl submitMenuAuthority occur exception");
        }
    }

    @Override
    public ApiResponse deleteMenuAuthority(MenuAuthorityDeleteReq deleteReq) {
        try {
            menuAuthorityBiz.deleteById(deleteReq.getMenuAuthorityId(), deleteReq.getUpdateUserId());
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("AuthorityServiceImpl deleteMenuAuthority occur exception, submitReq:{}", deleteReq, ex);
            return ApiResponse.buildBusExResponse("AuthorityServiceImpl deleteMenuAuthority occur exception");
        }
    }

    @Override
    public ApiResponse<MenuAuthorityTreeVo> findMenuAuthorityTree() {
        List<MenuAuthority> menuAuthorityList = menuAuthorityBiz.findAllMenuAuthority();

        if (CollectionUtils.isEmpty(menuAuthorityList)) {
            return ApiResponse.buildBusExResponse("menuAuthorityList isEmpty!");
        }
        return ApiResponse.buildSuccessResponse(builder.buildMenuAuthorityTree(menuAuthorityList));
    }
}
