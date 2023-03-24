package com.atguigu.gmall.rpc;


import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.dto.CategoryViewDo;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.vo.CategoryView;
import com.atguigu.gmall.service.CategoryViewService;
import com.atguigu.gmall.service.SkuInfoService;
import com.atguigu.gmall.service.SkuSaleAttrValueService;
import com.atguigu.gmall.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rpc/inner/product")
public class SkuDetailBizController {

    @Autowired
    SkuInfoService skuInfoService;

    @Autowired
    CategoryViewService categoryViewService;

    @Autowired
    SpuSaleAttrService spuSaleAttrService;

    @Autowired
    SkuSaleAttrValueService skuSaleAttrValueService;

    @GetMapping("/skuInfo/{skuId}")
    public Result<SkuInfo> getSkuInfo(@PathVariable("skuId") Long skuId){
        SkuInfo result = skuInfoService.getById(skuId);
        return Result.ok(result);
    }

    @GetMapping("/categoryView/{c3Id}")
    public Result<CategoryView> getCategoryViewByC3id(@PathVariable("c3Id") Long c3Id){
        CategoryViewDo categoryViewDo =  categoryViewService.getCategoryViewByC3id(c3Id);
        CategoryView categoryView = new CategoryView();
        categoryView.setCategory1Id(categoryViewDo.getId());
        categoryView.setCategory2Id(categoryViewDo.getId2());
        categoryView.setCategory3Id(categoryViewDo.getId3());
        categoryView.setCategory1Name(categoryViewDo.getName());
        categoryView.setCategory2Name(categoryViewDo.getName2());
        categoryView.setCategory3Name(categoryViewDo.getName3());
        return Result.ok(categoryView);
    }

    @GetMapping("/spuSaleAttr/{spuId}/{skuId}")
    public Result<List<SpuSaleAttr>> spuSaleAttr(@PathVariable("spuId") Long spuId,
                                                 @PathVariable("skuId") Long skuId){
        List<SpuSaleAttr> list =  skuSaleAttrValueService.spuSaleAttr(spuId,skuId);
        return Result.ok(list);
    }

    @GetMapping("/getItemJson/{spuId}")
    public Result<String> getItemJson(@PathVariable("spuId") Long spuId){
        Result<String> result =  skuSaleAttrValueService.getItemJson(spuId);
        return result;
    }


}
