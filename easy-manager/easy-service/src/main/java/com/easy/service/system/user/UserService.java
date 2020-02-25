package com.easy.service.system.user;

import com.easy.request.UserDeleteReq;
import com.easy.request.UserListQueryReq;
import com.easy.request.UserSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.UserListVo;
import com.easy.response.vo.UserVo;

import java.util.List;

/**
 * @Author rzq
 * @Desc 用户服务接口
 * @Date 2020-02-19
 **/
public interface UserService {
    /**
     * 用户信息提交：保存/修改
     *
     * @param submitReq
     * @return
     */
    ApiResponse submit(UserSubmitReq submitReq);

    /**
     * 用户删除请求
     *
     * @param deleteReq
     * @return
     */
    ApiResponse delete(UserDeleteReq deleteReq);

    /**
     * 查询用户列表
     *
     * @param queryReq
     * @return
     */
    ApiResponse<List<UserListVo>> findUserList(UserListQueryReq queryReq);

    /**
     * 根据用户名称查询用户
     *
     * @param userName
     * @return
     */
    ApiResponse<UserVo> findUserByUserName(String userName);
}
