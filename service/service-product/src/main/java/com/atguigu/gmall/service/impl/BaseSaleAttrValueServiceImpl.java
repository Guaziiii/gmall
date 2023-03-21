package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.SkuSaleAttrValueMapper;
import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.service.BaseSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue> implements BaseSaleAttrValueService {
}
