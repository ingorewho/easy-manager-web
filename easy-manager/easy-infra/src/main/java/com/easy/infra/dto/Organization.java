package com.easy.infra.dto;

import java.util.Date;

/**
 * organization数据库映射实体
 */
public class Organization {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 组织名称
     */
    private String organizationName;

    /**
     * 父组织节点id
     */
    private Long parentId;

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
     * 获取组织名称
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置组织名称
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * 获取父组织节点id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父组织节点id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
}