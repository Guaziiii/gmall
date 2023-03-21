package com.atguigu.gmall.service;

import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValue> {
    List<SpuSaleAttr> spuSaleAttr(Long spuId, Long skuId);
}
