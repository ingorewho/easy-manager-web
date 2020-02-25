package com.easy.service.business.goods.transfer;

import com.easy.infra.dto.Goods;
import com.easy.response.vo.GoodsListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author rzq
 * @Desc 商品Vo构建起
 * @Date 2020-02-18
 **/
@Component
public class GoodsVoBuilder {

    /**
     * 构建商品列表Vo
     * @param goodsList
     * @return
     */
    public List<GoodsListVo> buildGoodsListVoList(List<Goods> goodsList) {
        return null;
    }
}
