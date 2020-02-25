package com.easy.infra.dto;

import java.util.Date;

/**
 * role数据库映射实体
 */
public class Role {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色状态(0-正常 1-关闭)
     */
    private Integer status;

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
     * 获取角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色状态(0-正常 1-关闭)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置角色状态(0-正常 1-关闭)
     */
    public void setStatus(Integer status) {
        this.status = status;
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