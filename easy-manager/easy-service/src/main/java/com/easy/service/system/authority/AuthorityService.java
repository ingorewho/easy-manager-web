package com.easy.service.system.authority;

import com.easy.request.MenuAuthorityDeleteReq;
import com.easy.request.MenuAuthoritySubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.MenuAuthorityTreeVo;

/**
 * @Author rzq
 * @Desc 权限服务接口
 * @Date 2020-02-18
 **/
public interface AuthorityService {
    /**
     * 功能权限提交：新增/修改
     * @param submitReq
     * @return
     */
    ApiResponse submitMenuAuthority(MenuAuthoritySubmitReq submitReq);

    /**
     * 功能权限删除
     *
     * @param deleteReq
     * @return
     */
    ApiResponse deleteMenuAuthority(MenuAuthorityDeleteReq deleteReq);

    /**
     * 查询功能权限树
     *
     * @return
     */
    ApiResponse<MenuAuthorityTreeVo> findMenuAuthorityTree();
}
