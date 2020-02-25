package com.easy.service.system.authority.transfer;

import com.easy.infra.dto.MenuAuthority;
import com.easy.response.vo.MenuAuthorityTreeVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author rzq
 * @Desc 权限结果构建器
 * @Date 2020-02-18
 **/
@Component
public class AuthorityVoBuilder {

    /**
     * 根据功能权限集合构建权限树
     *
     * @param menuAuthorityList
     * @return
     */
    public MenuAuthorityTreeVo buildMenuAuthorityTree(List<MenuAuthority> menuAuthorityList) {
        return null;
    }
}
