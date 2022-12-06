package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.mapper.BaseCategory2Mapper;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.service.BaseAttrValueService;
import com.atguigu.gmall.service.BaseCategory2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseAttrValueServiceImpl extends ServiceImpl<BaseAttrValueMapper, BaseAttrValue> implements BaseAttrValueService {
}
