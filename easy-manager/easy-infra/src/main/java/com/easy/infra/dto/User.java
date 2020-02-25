package com.easy.infra.dto;

import java.util.Date;

/**
 * user1数据库映射实体
 */
public class User {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户状态(0-正常 1-冻结)
     */
    private Integer status;

    /**
     * 用户邮箱地址
     */
    private String email;

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
     * 获取用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户昵称
     */
    public String getUserNickName() {
        return userNickName;
    }

    /**
     * 设置用户昵称
     */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    /**
     * 获取用户状态(0-正常 1-冻结)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态(0-正常 1-冻结)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用户邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
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