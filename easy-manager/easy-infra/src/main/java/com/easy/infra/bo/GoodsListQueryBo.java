package com.easy.infra.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Author rzq
 * @Desc 商品列表查询BO
 * @Date 2020-02-18
 **/
@Data
public class GoodsListQueryBo {
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品标签
     */
    private Integer goodsLabel;
    /**
     * 商品创建时间开始范围
     */
    private Date createTimeStart;
    /**
     * 商品创建时间结束范围
     */
    private Date createTimeEnd;
    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 商品状态
     */
    private Integer goodsStatus;
}
