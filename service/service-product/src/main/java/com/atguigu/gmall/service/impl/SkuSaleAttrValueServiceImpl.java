package com.atguigu.gmall.service.impl;

import com.atguigu.common.result.Result;
import com.atguigu.common.util.JSONs;
import com.atguigu.gmall.mapper.SkuSaleAttrValueMapper;
import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.vo.SkuJsonVo;
import com.atguigu.gmall.service.SkuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue> implements SkuSaleAttrValueService {

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Override
    public List<SpuSaleAttr> spuSaleAttr(Long spuId, Long skuId) {
        List<SpuSaleAttr> list =  skuSaleAttrValueMapper.spuSaleAttr(spuId,skuId);
        return list;
    }

    @Override
    public Result<String> getItemJson(Long spuId) {
        List<SkuJsonVo> list =  skuSaleAttrValueMapper.getItemJson(spuId);
        HashMap<String, String> map = new HashMap<>();
        for (SkuJsonVo skuJsonVo : list) {
            String skuId = skuJsonVo.getSkuId();
            String skuValues = skuJsonVo.getSkuValues();
            map.put(skuValues,skuId);
        }
        String s = JSONs.toStr(map);
        return Result.ok(s);
    }
}
