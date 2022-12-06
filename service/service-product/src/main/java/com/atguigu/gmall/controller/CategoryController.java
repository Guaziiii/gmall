package com.atguigu.gmall.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import common.config.Knife4jConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "查询分类")
@RestController
@RequestMapping("/admin/product")
public class CategoryController {

    @Autowired
    private BaseCategory1Service baseCategory1Service;

    @Autowired
    private BaseCategory2Service baseCategory2Service;

    @Autowired
    private BaseCategory3Service baseCategory3Service;

    @Autowired
    private BaseAttrInfoService baseAttrInfoService;

    @Autowired
    private BaseAttrValueService baseAttrValueService;

    @ApiOperation(value = "获取一级分类")
    @GetMapping("/getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> list = baseCategory1Service.list();
        return Result.ok(list);
    }

    @ApiOperation(value = "获取二级分类")
    @GetMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") String id){
        List<BaseCategory2> list = baseCategory2Service.list(new LambdaQueryWrapper<BaseCategory2>().eq(BaseCategory2::getCategory1Id, id));
        return Result.ok(list);
    }

    @ApiOperation(value = "获取三级分类")
    @GetMapping("/getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") String id){
        List<BaseCategory3> list = baseCategory3Service.list(new LambdaQueryWrapper<BaseCategory3>().eq(BaseCategory3::getCategory2Id, id));
        return Result.ok(list);
    }

    @ApiOperation(value = "根据三级分类获取具体属性")
    @GetMapping("/attrInfoList/{c1id}/{c2id}/{c3id}")
    public Result getAttrValueByCategoryLevel(@PathVariable("c1id") Long c1id,
                                              @PathVariable("c2id")Long c2id,
                                              @PathVariable("c3id")Long c3id){
        List<BaseAttrInfo> list = baseAttrInfoService.getAttrValueByCategoryLevel(c1id,c2id,c3id);
        return Result.ok(list);
    }

    @ApiOperation(value = "添加商品属性")
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        if (baseAttrInfo.getId()!=null){
            //修改
            baseAttrInfoService.updateAttrInfoAndValue(baseAttrInfo);
        }else{
            baseAttrInfoService.saveAttrInfo(baseAttrInfo);
        }
        return Result.ok();
    }

    @ApiOperation(value = "查询商品属性")
    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId") String attrId){
        LambdaQueryWrapper<BaseAttrValue> eq = new LambdaQueryWrapper<BaseAttrValue>().eq(BaseAttrValue::getAttrId, attrId);
        List<BaseAttrValue> list = baseAttrValueService.list(eq);
        return Result.ok(list);
    }





}
