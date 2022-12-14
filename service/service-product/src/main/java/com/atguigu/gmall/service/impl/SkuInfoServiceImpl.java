package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.SkuInfoMapper;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.service.SkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {
    @Override
    public void saveSkuInfo(SkuInfo skuInfo) {

    }
}
