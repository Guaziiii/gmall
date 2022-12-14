package com.atguigu.gmall.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.service.BaseSaleAttrService;
import com.atguigu.gmall.service.BaseTradeMarkService;
import com.atguigu.gmall.service.SpuInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class SpuController {

    @Autowired
    SpuInfoService spuInfoService;

    @Autowired
    BaseSaleAttrService baseSaleAttrService;

    @Autowired
    BaseTradeMarkService baseTradeMarkService;

    @GetMapping("/{page}/{limit}")
    public Result selectSpuByPage(@RequestParam("category3Id") Long c3id,
                                  @PathVariable("page") Long page,
                                  @PathVariable("limit") Long limit){
        Page<SpuInfo> ipage = new Page<>(page, limit);
        Page<SpuInfo> page1 = spuInfoService.page(ipage, new LambdaQueryWrapper<SpuInfo>().eq(SpuInfo::getCategory3Id, c3id));
        return Result.ok(page1);

    }

    @GetMapping("/baseSaleAttrList")
    public Result baseSaleAttrList(){
        List<BaseSaleAttr> list = baseSaleAttrService.list();
        return Result.ok(list);
    }

    @GetMapping("/baseTrademark/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> list = baseTradeMarkService.list();
        return Result.ok(list);
    }

    @PostMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){
        spuInfoService.saveSpuInfo(spuInfo);
        return Result.ok();
    }

}
