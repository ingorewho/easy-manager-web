package com.easy.infra.dto;

import java.util.Date;

/**
 * goods数据库映射实体
 */
public class Goods {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品描述
     */
    private String goodsDescription;

    /**
     * 商品原价
     */
    private Long originPrice;

    /**
     * 商品供货价
     */
    private Long supplyPrice;

    /**
     * 商品折扣
     */
    private Long discount;

    /**
     * 商品折扣价
     */
    private Long discountPrice;

    /**
     * 商品库存
     */
    private Long stock;

    /**
     * 商品标签
     */
    private Integer goodsLabel;

    /**
     * 商品状态（0-未上架 1-上架）
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
     * 获取商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取商品描述
     */
    public String getGoodsDescription() {
        return goodsDescription;
    }

    /**
     * 设置商品描述
     */
    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    /**
     * 获取商品原价
     */
    public Long getOriginPrice() {
        return originPrice;
    }

    /**
     * 设置商品原价
     */
    public void setOriginPrice(Long originPrice) {
        this.originPrice = originPrice;
    }

    /**
     * 获取商品供货价
     */
    public Long getSupplyPrice() {
        return supplyPrice;
    }

    /**
     * 设置商品供货价
     */
    public void setSupplyPrice(Long supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    /**
     * 获取商品折扣
     */
    public Long getDiscount() {
        return discount;
    }

    /**
     * 设置商品折扣
     */
    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    /**
     * 获取商品折扣价
     */
    public Long getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 设置商品折扣价
     */
    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * 获取商品库存
     */
    public Long getStock() {
        return stock;
    }

    /**
     * 设置商品库存
     */
    public void setStock(Long stock) {
        this.stock = stock;
    }

    /**
     * 获取商品标签
     */
    public Integer getGoodsLabel() {
        return goodsLabel;
    }

    /**
     * 设置商品标签
     */
    public void setGoodsLabel(Integer goodsLabel) {
        this.goodsLabel = goodsLabel;
    }

    /**
     * 获取商品状态（0-未上架 1-上架）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置商品状态（0-未上架 1-上架）
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