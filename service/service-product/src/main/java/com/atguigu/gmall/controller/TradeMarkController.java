package com.atguigu.gmall.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.mapper.BaseTrademarkMapper;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.service.BaseTradeMarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class TradeMarkController {

    @Autowired
    private BaseTradeMarkService baseTradeMarkService;

    @GetMapping("/baseTrademark/{page}/{limit}")
    @ApiModelProperty(value = "获取品牌分页列表")
    public Result baseTrademark(@PathVariable("page") Long page,
                                @PathVariable("limit")Long limit){
        Page<BaseTrademark> pageList = baseTradeMarkService.page(new Page<BaseTrademark>(page, limit));
        return Result.ok(pageList);
    }

    @PostMapping("/baseTrademark/save")
    @ApiModelProperty(value = "保存品牌")
    public Result save(@RequestBody BaseTrademark baseTrademark){
        baseTradeMarkService.save(baseTrademark);
        return Result.ok();
    }

    @PutMapping("/baseTrademark/update")
    @ApiModelProperty(value = "修改品牌")
    public Result update(@RequestBody BaseTrademark baseTrademark){
        baseTradeMarkService.updateById(baseTrademark);
        return Result.ok();
    }

    @DeleteMapping("/baseTrademark/remove/{id}")
    @ApiModelProperty(value = "删除品牌")
    public Result remove(@PathVariable("id") Long id){
        baseTradeMarkService.removeById(id);
        return Result.ok();
    }

    @GetMapping("/baseTrademark/get/{id}")
    @ApiModelProperty(value = "根据id获取具体商标")
    public Result get(@PathVariable("id") Long id){
        BaseTrademark id1 = baseTradeMarkService.getById(id);
        return Result.ok(id1);
    }





}
