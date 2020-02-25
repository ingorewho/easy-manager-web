package com.easy.response.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author rzq
 * @Desc 商品列表Vo
 * @Date 2020-02-16
 **/
@Data
@ToString
public class GoodsListVo implements Serializable {
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
     * 商品标签名称
     */
    private String goodsLabelName;

    /**
     * 商品状态（0-未上架 1-上架）
     */
    private Integer status;

    /**
     * 创建者id
     */
    private Long createUserId;

    /**
     * 创建者名称
     */
    private String createUserMame;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者id
     */
    private Long updateUserId;

    /**
     * 更新者名称
     */
    private String updateUserMame;

    /**
     * 更新时间
     */
    private Date updateDate;
}
