package com.atguigu.gmall.service;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;


public interface SkuInfoService extends IService<SkuInfo> {
    /**
     * sku销售属性保存
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);
}
