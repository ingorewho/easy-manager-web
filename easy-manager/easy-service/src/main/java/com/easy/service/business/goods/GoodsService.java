package com.easy.service.business.goods;

import com.easy.request.GoodsDeleteReq;
import com.easy.request.GoodsListQueryReq;
import com.easy.request.GoodsStatusUpdateReq;
import com.easy.request.GoodsSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.GoodsListVo;

import java.util.List;

/**
 * @Author rzq
 * @Desc 商品服务
 * @Date 2020-02-16
 **/
public interface GoodsService {
    /**
     * 提交商品请求：保存/修改
     *
     * @param submitReq
     * @return
     */
    ApiResponse submit(GoodsSubmitReq submitReq);

    /**
     * 删除商品请求
     *
     * @param deleteReq
     * @return
     */
    ApiResponse delete(GoodsDeleteReq deleteReq);

    /**
     * 更新商品状态
     *
     * @param updateReq
     * @return
     */
    ApiResponse updateGoodsStatus(GoodsStatusUpdateReq updateReq);

    /**
     * 查询商品列表
     *
     * @param queryReq
     * @return
     */
    ApiResponse<List<GoodsListVo>> findGoodsList(GoodsListQueryReq queryReq);
}
