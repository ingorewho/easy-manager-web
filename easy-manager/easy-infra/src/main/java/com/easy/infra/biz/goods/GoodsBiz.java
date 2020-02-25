package com.easy.infra.biz.goods;

import com.easy.infra.bo.GoodsListQueryBo;
import com.easy.infra.dto.Goods;

import java.util.List;

/**
 * @Author rzq
 * @Desc 商品业务接口
 * @Date 2020-02-16
 **/
public interface GoodsBiz {
    /**
     * 保存或更新商品
     *
     * @param goods
     */
    void saveOrUpdate(Goods goods);

    /**
     * 批量删除商品
     *
     * @param goodsIds
     */
    void deleteByIds(List<Long> goodsIds, Long updateUserId);

    /**
     * 批量更新商品状态
     *
     * @param goodsIds
     * @param status
     */
    void updateGoodsStatus(List<Long> goodsIds, Integer status, Long updateUserId);

    /**
     * 查询商品列表
     *
     * @param queryBo
     * @return
     */
    List<Goods> findByListQueryBo(GoodsListQueryBo queryBo);
}
