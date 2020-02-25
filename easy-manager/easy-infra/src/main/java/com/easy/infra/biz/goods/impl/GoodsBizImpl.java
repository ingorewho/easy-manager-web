package com.easy.infra.biz.goods.impl;

import com.easy.infra.biz.goods.GoodsBiz;
import com.easy.infra.bo.GoodsListQueryBo;
import com.easy.infra.dao.GoodsMapper;
import com.easy.infra.dto.Goods;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author rzq
 * @Desc 商品业务接口实现类
 * @Date 2020-02-16
 **/
@Service
public class GoodsBizImpl implements GoodsBiz {
    private Logger logger = LoggerFactory.getLogger(GoodsBizImpl.class);

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void saveOrUpdate(Goods goods) {
        if (Objects.nonNull(goods.getId())) {
            goodsMapper.insert(goods);
        } else {
            goodsMapper.update(goods);
        }
    }

    @Override
    public void deleteByIds(List<Long> goodsIds, Long updateUserId) {
        if (CollectionUtils.isEmpty(goodsIds)) {
            logger.warn("GoodsBizImpl deleteByIds goodsIds isEmpty");
            return;
        }
        goodsMapper.deleteByPkIds(goodsIds, updateUserId);
    }

    @Override
    public void updateGoodsStatus(List<Long> goodsIds, Integer status, Long updateUserId) {
        if (CollectionUtils.isEmpty(goodsIds)) {
            logger.warn("GoodsBizImpl deleteByIds goodsIds isEmpty");
            return;
        }
        goodsMapper.updateGoodsStatus(goodsIds, status, updateUserId);
    }

    @Override
    public List<Goods> findByListQueryBo(GoodsListQueryBo queryBo) {
        return null;
    }
}
