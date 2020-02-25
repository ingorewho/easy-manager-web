package com.easy.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author rzq
 * @Desc 商品提交请求
 * @Date 2020-02-16
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsSubmitReq implements Serializable {
    /**
     * 商品id
     */
    private Long goodsId;
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
    private BigDecimal originPrice;
    /**
     * 商品供货价
     */
    private BigDecimal supplyPrice;
    /**
     * 商品折扣
     */
    private BigDecimal discount;
    /**
     * 商品折扣价
     */
    private BigDecimal discountPrice;
    /**
     * 商品库存
     */
    private Long stock;
    /**
     * 操作人id
     */
    private Long operatorId;
}
