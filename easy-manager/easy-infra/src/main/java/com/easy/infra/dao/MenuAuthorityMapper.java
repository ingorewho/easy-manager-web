package com.easy.infra.dao;

import com.easy.infra.dto.MenuAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuAuthorityMapper {
    /**
     * 保存数据
     */
    int insert(MenuAuthority record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(MenuAuthority record);

    /**
     * 通过条件查询数据信息
     */
    List<MenuAuthority> select(MenuAuthority record);

    /**
     * 通过条件查询唯一数据信息
     */
    MenuAuthority selectOne(MenuAuthority record);

    /**
     * 根据主键id物理删除功能权限
     *
     * @param id
     */
    void deleteByPkId(@Param(value = "id") Long id);

    /**
     * 查询所以的功能权限
     *
     * @return
     */
    List<MenuAuthority> selectAll();
}