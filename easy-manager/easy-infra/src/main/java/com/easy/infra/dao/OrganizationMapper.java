package com.easy.infra.dao;

import com.easy.infra.dto.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper {
    /**
     * 保存数据
     */
    int insert(Organization record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(Organization record);

    /**
     * 通过条件查询数据信息
     */
    List<Organization> select(Organization record);

    /**
     * 通过条件查询唯一数据信息
     */
    Organization selectOne(Organization record);

    /**
     * 根据主键id物理删除组织节点
     *
     * @param id
     */
    void deleteByPkId(@Param(value = "id") Long id);

    /**
     * 查询所有组织节点
     *
     * @return
     */
    List<Organization> selectAll();
}