package com.atguigu.gmall.service;

import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SpuSaleAttrService extends IService<SpuSaleAttr> {
    /**
     * 查找Spu商品销售属性
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> selectBySpuId(Long spuId);
}
