package com.easy.infra.biz.organization.impl;

import com.easy.infra.biz.organization.OrganizationBiz;
import com.easy.infra.dao.OrganizationMapper;
import com.easy.infra.dto.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author rzq
 * @Desc 组织业务接口实现类
 * @Date 2020-02-18
 **/
@Service
public class OrganizationBizImpl implements OrganizationBiz {
    private Logger logger = LoggerFactory.getLogger(OrganizationBizImpl.class);

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public void saveOrUpdate(Organization organization) {
        if (Objects.nonNull(organization.getId())) {
            organizationMapper.update(organization);
        } else {
            organizationMapper.insert(organization);
        }
    }

    @Override
    public void deleteById(Long organizationId, Long updateUserId) {
        if (Objects.isNull(organizationId)) {
            logger.warn("OrganizationBizImpl deleteById organizationId isNull!");
            return;
        }
        organizationMapper.deleteByPkId(organizationId);

        //todo 级联删除子节点
    }

    @Override
    public List<Organization> findAllOrganizations() {
        return organizationMapper.selectAll();
    }
}
