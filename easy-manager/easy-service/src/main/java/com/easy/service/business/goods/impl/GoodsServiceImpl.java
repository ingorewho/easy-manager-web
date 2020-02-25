package com.easy.service.business.goods.impl;

import com.easy.service.business.goods.GoodsService;
import com.easy.service.business.goods.transfer.GoodsParamTransfer;
import com.easy.service.business.goods.transfer.GoodsVoBuilder;
import com.easy.service.business.goods.validator.GoodsReqValidator;
import com.easy.infra.biz.goods.GoodsBiz;
import com.easy.infra.bo.GoodsListQueryBo;
import com.easy.infra.dto.Goods;
import com.easy.request.GoodsDeleteReq;
import com.easy.request.GoodsListQueryReq;
import com.easy.request.GoodsStatusUpdateReq;
import com.easy.request.GoodsSubmitReq;
import com.easy.response.ApiResponse;
import com.easy.response.vo.GoodsListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rzq
 * @Desc 商品接口实现
 * @Date 2020-02-16
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
    private Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsBiz goodsBiz;
    @Autowired
    private GoodsParamTransfer paramTransfer;
    @Autowired
    private GoodsReqValidator reqValidator;
    @Autowired
    private GoodsVoBuilder builder;

    @Override
    public ApiResponse submit(GoodsSubmitReq submitReq) {
        try {
            Goods goods = paramTransfer.transferGoods(submitReq);
            goodsBiz.saveOrUpdate(goods);
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("GoodsServiceImpl submit occur exception, submitReq:{}", submitReq, ex);
            return ApiResponse.buildBusExResponse("GoodsServiceImpl submit occur exception");
        }
    }

    @Override
    public ApiResponse delete(GoodsDeleteReq deleteReq) {
        try {
            goodsBiz.deleteByIds(deleteReq.getGoodsIds(), deleteReq.getUpdateUserId());
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("GoodsServiceImpl delete occur exception, deleteReq:{}", deleteReq, ex);
            return ApiResponse.buildBusExResponse("GoodsServiceImpl delete occur exception");
        }
    }

    @Override
    public ApiResponse updateGoodsStatus(GoodsStatusUpdateReq updateReq) {
        try {
            goodsBiz.updateGoodsStatus(updateReq.getGoodsIds(), updateReq.getStatus(), updateReq.getOperatorId());
            return ApiResponse.buildSuccessResponse(null);
        } catch (Exception ex) {
            logger.error("GoodsServiceImpl updateGoodsStatus occur exception, updateReq:{}", updateReq, ex);
            return ApiResponse.buildBusExResponse("GoodsServiceImpl updateGoodsStatus occur exception");
        }
    }

    @Override
    public ApiResponse<List<GoodsListVo>> findGoodsList(GoodsListQueryReq queryReq) {
        try {
            GoodsListQueryBo queryBo = paramTransfer.transferQueryBo(queryReq);
            List<Goods> goodsList = goodsBiz.findByListQueryBo(queryBo);
            return ApiResponse.buildSuccessResponse(builder.buildGoodsListVoList(goodsList));
        } catch (Exception ex) {
            logger.error("GoodsServiceImpl findGoodsList occur exception, queryReq:{}", queryReq, ex);
            return ApiResponse.buildBusExResponse("GoodsServiceImpl findGoodsList occur exception");
        }
    }
}
