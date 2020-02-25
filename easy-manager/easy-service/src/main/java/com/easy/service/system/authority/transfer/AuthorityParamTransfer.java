package com.easy.service.system.authority.transfer;

import com.easy.infra.dto.MenuAuthority;
import com.easy.request.MenuAuthoritySubmitReq;
import com.easy.util.PropertyCopierUtil;
import org.springframework.stereotype.Component;

/**
 * @Author rzq
 * @Desc 权限参数转换
 * @Date 2020-02-18
 **/
@Component
public class AuthorityParamTransfer {

    /**
     * 转换请求参数
     *
     * @param submitReq
     * @return
     */
    public MenuAuthority transferMenuAuthority(MenuAuthoritySubmitReq submitReq) {
        return PropertyCopierUtil.copy(submitReq, MenuAuthority.class);
    }
}
