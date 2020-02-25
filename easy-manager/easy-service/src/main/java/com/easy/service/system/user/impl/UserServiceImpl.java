package com.easy.service.system.user.impl;

import com.easy.service.system.user.UserService;
import com.easy.service.system.user.transfer.UserParamTransfer;
import com.easy.service.system.user.transfer.UserVoBuilder;
import com.easy.infra.biz.user.UserBiz;
import com.easy.infra.biz.user.UserRoleBiz;
import com.easy.infra.bo.UserListQueryBo;
import com.easy.infra.dto.User;
import com.easy.infra.dto.UserRole;
import com.easy.request.UserDeleteReq;
import com.easy.request.UserListQueryReq;
import com.easy.request.UserSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.UserListVo;
import com.easy.response.vo.UserVo;
import com.easy.util.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户服务接口实现类
 * @Date 2020-02-19
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private UserRoleBiz userRoleBiz;
    @Autowired
    private UserParamTransfer transfer;
    @Autowired
    private UserVoBuilder builder;

    @Override
    public ApiResponse submit(UserSubmitReq submitReq) {
        try {
            User user = transfer.transferUser(submitReq);
            List<UserRole> userRoleList = transfer.transferUserRoleList(submitReq);
            userBiz.saveOrUpdate(user);
            userRoleBiz.saveOrUpdate(userRoleList);
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            log.error("UserServiceImpl submit occur exception, submitReq:{}", submitReq, ex);
            return ApiResponse.buildBusExResponse("UserServiceImpl submit occur exception");
        }
    }

    @Override
    public ApiResponse delete(UserDeleteReq deleteReq) {
        try {
            userBiz.deleteByIds(Lists.newArrayList(deleteReq.getUserId()), deleteReq.getUpdateUserId());
            userRoleBiz.deleteByUserIds(Lists.newArrayList(deleteReq.getUserId()), deleteReq.getUpdateUserId());
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            log.error("UserServiceImpl delete occur exception, deleteReq:{}", deleteReq, ex);
            return ApiResponse.buildBusExResponse("UserServiceImpl delete occur exception");
        }
    }

    @Override
    public ApiResponse<List<UserListVo>> findUserList(UserListQueryReq queryReq) {
        try {
            UserListQueryBo queryBo = transfer.transferUserListQueryBo(queryReq);

            List<User> userList = userBiz.findUserByQueryBo(queryBo);

            List<Long> userIds = ListUtil.distinctList(userList, User::getId);
            List<UserRole> userRoleList = userRoleBiz.findByUserIds(userIds);
            return ApiResponse.buildSuccessResponse(builder.buildUserList(userList, userRoleList));
        } catch (Exception ex) {
            log.error("UserServiceImpl findUserList occur exception, queryReq:{}", queryReq, ex);
            return ApiResponse.buildBusExResponse("UserServiceImpl findUserList occur exception");
        }
    }

    @Override
    public ApiResponse<UserVo> findUserByUserName(String userName) {
        try {
            User user = userBiz.findByUserName(userName);
            return ApiResponse.buildSuccessResponse(builder.buildUser(user));
        } catch (Exception ex) {
            log.error("UserServiceImpl findUserByUserName occur exception, userName:{}", userName, ex);
            return ApiResponse.buildBusExResponse("UserServiceImpl findUserByUserName occur exception");
        }
    }
}
