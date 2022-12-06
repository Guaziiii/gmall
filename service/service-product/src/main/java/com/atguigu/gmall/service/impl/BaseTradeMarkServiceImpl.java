package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.BaseTrademarkMapper;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.service.BaseTradeMarkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseTradeMarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark> implements BaseTradeMarkService {
}
