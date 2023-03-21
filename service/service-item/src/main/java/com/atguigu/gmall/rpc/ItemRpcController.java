package com.atguigu.gmall.rpc;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import com.atguigu.gmall.serivce.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rpc/inner/item")
public class ItemRpcController {

    @Autowired
    ItemService itemService;

    @GetMapping("/sku/{skuId}")
    public Result<SkuDetailVo> getSkuDetail(@PathVariable("skuId") Long skuId){
        SkuDetailVo result =  itemService.getSkuDetail(skuId);
        return Result.ok(result);
    }
}
