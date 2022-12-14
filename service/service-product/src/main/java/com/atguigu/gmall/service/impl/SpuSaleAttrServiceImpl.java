package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.SpuSaleAttrMapper;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuSaleAttrServiceImpl extends ServiceImpl<SpuSaleAttrMapper,SpuSaleAttr> implements SpuSaleAttrService {

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Override
    public List<SpuSaleAttr> selectBySpuId(Long spuId) {
        List<SpuSaleAttr> list  = spuSaleAttrMapper.selectBySpuId(spuId);
        return list;
    }
}
