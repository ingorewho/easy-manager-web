package com.easy.infra.dto;

import java.util.Date;

/**
 * menu_authority数据库映射实体
 */
public class MenuAuthority {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 菜单按钮编码
     */
    private String menuCode;

    /**
     * 菜单按钮名称
     */
    private String menuName;

    /**
     * 父级权限id
     */
    private String parentId;

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
     * 获取菜单按钮编码
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 设置菜单按钮编码
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 获取菜单按钮名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单按钮名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取父级权限id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级权限id
     */
    public void setParentId(String parentId) {
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