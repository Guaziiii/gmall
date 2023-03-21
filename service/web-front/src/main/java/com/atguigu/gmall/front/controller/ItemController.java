package com.atguigu.gmall.front.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.feign.item.ItemFeignClient;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @Autowired
    ItemFeignClient itemFeignClient;

    @GetMapping("/{skuId}.html")
    public String item(@PathVariable("skuId") Long skuId, Model model){

        Result<SkuDetailVo> skuDetail = itemFeignClient.getSkuDetail(skuId);

        SkuDetailVo data = skuDetail.getData();
        // 分类
        model.addAttribute("categoryView",data.getCategoryView());

        //skuinfo
        model.addAttribute("skuInfo",data.getSkuInfo());

        //价格
        model.addAttribute("price",data.getPrice());

        //spu销售属性
        model.addAttribute("spuSaleAttrList",data.getSpuSaleAttrList());

        model.addAttribute("valuesSkuJson",data.getValuesSkuJson());

        return "item/index";
    }
}
