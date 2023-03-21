package com.atguigu.gmall.serivce.impl;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.feign.product.SkuFeignClient;
import com.atguigu.gmall.model.dto.CategoryViewDo;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.vo.CategoryVo;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import com.atguigu.gmall.model.vo.CategoryView;
import com.atguigu.gmall.serivce.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    SkuFeignClient skuFeignClient;


    @Override
    public SkuDetailVo getSkuDetail(Long skuId) {

        SkuDetailVo skuDetailVo = new SkuDetailVo();
        //先查skuInfo
        Result<SkuInfo> info = skuFeignClient.getSkuInfo(skuId);
        SkuInfo data = info.getData();
        skuDetailVo.setSkuInfo(data);

        //再查categoryView
        Long c3id = data.getCategory3Id();
        Result<CategoryView> categoryView = skuFeignClient.getCategoryViewByC3id(c3id);
        skuDetailVo.setCategoryView(categoryView.getData());

        //设置价格
        skuDetailVo.setPrice(data.getPrice());

        //设置销售属性和销售属性的值
        List<SpuSaleAttr> list = skuFeignClient.spuSaleAttr(data.getSpuId(), skuId).getData();
        skuDetailVo.setSpuSaleAttrList(list);

        //设置json

        return skuDetailVo;
    }
}
