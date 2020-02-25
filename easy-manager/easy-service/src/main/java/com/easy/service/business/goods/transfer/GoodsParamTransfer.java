package com.easy.service.business.goods.transfer;

import com.easy.infra.bo.GoodsListQueryBo;
import com.easy.infra.dto.Goods;
import com.easy.request.GoodsListQueryReq;
import com.easy.request.GoodsSubmitReq;
import com.easy.util.PropertyCopierUtil;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-16
 **/
@Component
public class GoodsParamTransfer {

    /**
     * 转换提交请求
     *
     * @param submitReq
     * @return
     */
    public Goods transferGoods(GoodsSubmitReq submitReq) {
        Goods goods = PropertyCopierUtil.copy(submitReq, Goods.class);
        if (goods == null) {
            return null;
        }

        if (Objects.isNull(goods.getId())) {
            goods.setCreateUserId(submitReq.getOperatorId());
            return goods;
        }
        goods.setUpdateUserId(submitReq.getOperatorId());
        return goods;
    }

    /**
     * 转换查询列表请求
     *
     * @param queryReq
     * @return
     */
    public GoodsListQueryBo transferQueryBo(GoodsListQueryReq queryReq) {
        return null;
    }
}
