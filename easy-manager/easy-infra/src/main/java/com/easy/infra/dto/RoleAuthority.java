package com.easy.infra.dto;

import java.util.Date;

/**
 * role_authority数据库映射实体
 */
public class RoleAuthority {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 关联功能权限id
     */
    private Long menuAuthorityId;

    /**
     * 创建者id
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者id
     */
    private Long updateUserId;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 逻辑删除标示(0-未删除 1-已删除)
     */
    private Boolean deleted;

    /**
     * 获取主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取关联功能权限id
     */
    public Long getMenuAuthorityId() {
        return menuAuthorityId;
    }

    /**
     * 设置关联功能权限id
     */
    public void setMenuAuthorityId(Long menuAuthorityId) {
        this.menuAuthorityId = menuAuthorityId;
    }

    /**
     * 获取创建者id
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建者id
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者id
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置更新者id
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取逻辑删除标示(0-未删除 1-已删除)
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除标示(0-未删除 1-已删除)
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}