package com.atguigu.gmall.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.mapper.SkuInfoMapper;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.service.SkuInfoService;
import com.atguigu.gmall.service.SpuImageService;
import com.atguigu.gmall.service.SpuInfoService;
import com.atguigu.gmall.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class SkuController {
    @Autowired
    SkuInfoService skuInfoService;

    @Autowired
    SpuImageService spuImageService;

    @Autowired
    SpuSaleAttrService spuSaleAttrService;


    @GetMapping("/spuImageList/{spuId}")
    public Result spuImageList(@PathVariable("spuId") Long spuId){
        LambdaQueryWrapper<SpuImage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SpuImage::getSpuId,spuId);
        return Result.ok(spuImageService.list(wrapper));
    }

    @GetMapping("/spuSaleAttrList/{spuId}")
    public Result spuSaleAttrList(@PathVariable("spuId") Long spuId){
        List<SpuSaleAttr> list = spuSaleAttrService.selectBySpuId(spuId);
        return Result.ok(list);
    }

    @PostMapping("/saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo) {
        skuInfoService.saveSkuInfo(skuInfo);
        return Result.ok();
    }

    @GetMapping("/list/{page}/{limit}")
    public Result list(@PathVariable("page") Long page,
                       @PathVariable("limit") Long limit){
        Page<SkuInfo> skuInfoPage = new Page<>(page,limit);
        Page<SkuInfo> skuInfo = skuInfoService.page(skuInfoPage);
        return Result.ok(skuInfo);
    }

    @GetMapping("/onSale/{skuId}")
    public Result OnSale(@PathVariable("skuId") Long skuId){
        skuInfoService.updateSale(skuId,1);
        return Result.ok();
    }

    @GetMapping("/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable("skuId") Long skuId){
        skuInfoService.updateSale(skuId,0);
        return Result.ok();
    }

}

