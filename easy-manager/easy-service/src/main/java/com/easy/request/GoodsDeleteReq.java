package com.easy.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author rzq
 * @Desc 商品删除请求
 * @Date 2020-02-16
 **/
@Data
public class GoodsDeleteReq implements Serializable {
    /**
     * 商品id集合
     */
    private List<Long> goodsIds;
    /**
     * 操作人id
     */
    private Long updateUserId;
}
