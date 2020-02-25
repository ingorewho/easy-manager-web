package com.easy.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author rzq
 * @Desc 更改商品状态请求
 * @Date 2020-02-18
 **/
@Data
public class GoodsStatusUpdateReq implements Serializable {
    /**
     * 商品状态
     */
    private Integer status;
    /**
     * 商品id集合
     */
    private List<Long> goodsIds;
    /**
     * 更新者id
     */
    private Long operatorId;
}
