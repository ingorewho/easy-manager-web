package com.easy.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author rzq
 * @Desc 商品列表查询请求
 * @Date 2020-02-16
 **/
@Data
@ToString
public class GoodsListQueryReq implements Serializable {
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
     * 创建人名称
     */
    private String createUserName;
    /**
     * 商品状态
     */
    private Integer goodsStatus;
}
