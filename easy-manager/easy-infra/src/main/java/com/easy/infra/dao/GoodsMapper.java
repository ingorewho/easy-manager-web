package com.easy.infra.dao;

import com.easy.infra.bo.GoodsListQueryBo;
import com.easy.infra.dto.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     * 保存数据
     */
    int insert(Goods record);

    /**
     * 更新主键ID对应的非NULL字段数据
     */
    int update(Goods record);

    /**
     * 通过条件查询数据信息
     */
    List<Goods> select(Goods record);

    /**
     * 通过条件查询唯一数据信息
     */
    Goods selectOne(Goods record);

    /**
     * 根据主键id批量删除商品
     *
     * @param ids
     * @param updateUserId
     */
    void deleteByPkIds(@Param(value = "ids") List<Long> ids, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 更新商品状态
     *
     * @param ids
     * @param status
     * @param updateUserId
     */
    void updateGoodsStatus(@Param(value = "ids") List<Long> ids, @Param(value = "status") Integer status, @Param(value = "updateUserId") Long updateUserId);

    /**
     * 查询商品列表
     *
     * @param queryBo
     * @return
     */
    List<Goods> selectGoodsList(GoodsListQueryBo queryBo);
}