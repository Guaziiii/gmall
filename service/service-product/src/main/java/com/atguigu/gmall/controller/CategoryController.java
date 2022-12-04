package com.atguigu.gmall.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.service.BaseCategory1Service;
import com.atguigu.gmall.service.BaseCategory2Service;
import com.atguigu.gmall.service.BaseCategory3Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import common.config.Knife4jConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "查询分类")
@RestController
@Import(Knife4jConfiguration.class)
@RequestMapping("/admin/product")
public class CategoryController {

    @Autowired
    private BaseCategory1Service baseCategory1Service;

    @Autowired
    private BaseCategory2Service baseCategory2Service;

    @Autowired
    private BaseCategory3Service baseCategory3Service;

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




}
