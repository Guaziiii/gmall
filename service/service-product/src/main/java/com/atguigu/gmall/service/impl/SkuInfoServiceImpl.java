package com.atguigu.gmall.service.impl;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.mapper.SkuInfoMapper;
import com.atguigu.gmall.model.product.SkuAttrValue;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.service.SkuAttrValueService;
import com.atguigu.gmall.service.SkuImageService;
import com.atguigu.gmall.service.SkuInfoService;
import com.atguigu.gmall.service.SkuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {

    @Autowired
    SkuInfoService skuInfoService;

    @Autowired
    SkuImageService skuImageService;

    @Autowired
    SkuAttrValueService skuAttrValueService;

    @Autowired
    SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Override
    public Result saveSkuInfo(SkuInfo skuInfo) {

        skuInfoService.save(skuInfo);
        List<SkuImage> imageList = skuInfo.getSkuImageList();
        for (SkuImage skuImage : imageList) {
            skuImage.setSkuId(skuInfo.getId());
        }
        skuImageService.saveBatch(imageList);

        List<SkuAttrValue> list = skuInfo.getSkuAttrValueList();
        for (SkuAttrValue skuAttrValue : list) {
            skuAttrValue.setSkuId(skuInfo.getId());
        }
        skuAttrValueService.saveBatch(list);

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
            skuSaleAttrValue.setSpuId(skuInfo.getSpuId());
            skuSaleAttrValue.setSkuId(skuInfo.getId());
        }
        skuSaleAttrValueService.saveBatch(skuSaleAttrValueList);

        return Result.ok();
    }

    public void updateSale(Long skuId,int status) {
        skuInfoMapper.changeStatus(skuId,status);
    }

}
