package com.atguigu.gmall.service;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;


public interface SkuInfoService extends IService<SkuInfo> {
    /**
     * sku销售属性保存
     * @param skuInfo
     */
    Result saveSkuInfo(SkuInfo skuInfo);

    /**
     * sku上下架状态改变
     * @param skuId
     */
    void updateSale(Long skuId,int status);

}
