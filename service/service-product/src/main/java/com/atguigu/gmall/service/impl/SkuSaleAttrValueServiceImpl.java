package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.SkuSaleAttrValueMapper;
import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.service.SkuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue> implements SkuSaleAttrValueService {

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Override
    public List<SpuSaleAttr> spuSaleAttr(Long spuId, Long skuId) {
        List<SpuSaleAttr> list =  skuSaleAttrValueMapper.spuSaleAttr(spuId,skuId);
        return list;
    }
}
