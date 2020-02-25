package com.easy.infra.biz.authority.impl;

import com.easy.infra.biz.authority.MenuAuthorityBiz;
import com.easy.infra.dao.MenuAuthorityMapper;
import com.easy.infra.dto.MenuAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author rzq
 * @Desc 权限业务底层业务接口实现
 * @Date 2020-02-15
 **/
@Service
public class MenuAuthorityBizImpl implements MenuAuthorityBiz {
    private Logger logger = LoggerFactory.getLogger(MenuAuthorityBizImpl.class);

    @Autowired
    private MenuAuthorityMapper authorityMapper;

    @Override
    public void saveOrUpdate(MenuAuthority menuAuthority) {
        if (Objects.nonNull(menuAuthority.getId())) {
            authorityMapper.update(menuAuthority);
        } else {
            authorityMapper.insert(menuAuthority);
        }
    }

    @Override
    public void deleteById(Long menuAuthorityId, Long updateUserId) {
        if (Objects.isNull(menuAuthorityId)) {
            logger.warn("MenuAuthorityBizImpl deleteById menuAuthorityId isNull!");
            return;
        }

        authorityMapper.deleteByPkId(menuAuthorityId);

        // todo 同步删除子功能权限信息
    }

    @Override
    public List<MenuAuthority> findAllMenuAuthority() {
        return authorityMapper.selectAll();
    }
}
