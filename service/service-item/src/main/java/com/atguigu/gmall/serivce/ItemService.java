package com.atguigu.gmall.serivce;

import com.atguigu.gmall.model.vo.SkuDetailVo;

public interface ItemService {
    /**
     * 商品详情
     * @param skuId
     * @return
     */
    SkuDetailVo getSkuDetail(Long skuId);
}
