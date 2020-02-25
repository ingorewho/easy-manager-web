package com.easy.infra.biz.authority;

import com.easy.infra.dto.MenuAuthority;

import java.util.List;

/**
 * @Author rzq
 * @Desc 权限底层业务接口
 * @Date 2020-02-15
 **/
public interface MenuAuthorityBiz {
    /**
     * 保存或更新功能权限
     *
     * @param menuAuthority
     */
    void saveOrUpdate(MenuAuthority menuAuthority);

    /**
     * 通过id删除功能权限
     *
     * @param menuAuthorityId
     * @param updateUserId
     */
    void deleteById(Long menuAuthorityId, Long updateUserId);

    /**
     * 查询所有的功能权限
     *
     * @return
     */
    List<MenuAuthority> findAllMenuAuthority();
}
