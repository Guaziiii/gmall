package com.atguigu.gmall.feign.product;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.vo.CategoryView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/rpc/inner/product")
@FeignClient("service-product")
public interface SkuFeignClient {


    @GetMapping("/skuInfo/{skuId}")
    Result<SkuInfo> getSkuInfo(@PathVariable("skuId") Long skuId);

    @GetMapping("/categoryView/{c3Id}")
    Result<CategoryView> getCategoryViewByC3id(@PathVariable("c3Id") Long c3Id);

    @GetMapping("/spuSaleAttr/{spuId}/{skuId}")
    Result<List<SpuSaleAttr>> spuSaleAttr(@PathVariable("spuId") Long spuId,
                                                 @PathVariable("skuId") Long skuId);

}
