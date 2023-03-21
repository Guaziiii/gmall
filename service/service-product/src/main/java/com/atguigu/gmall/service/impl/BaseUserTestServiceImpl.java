package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.BaseUserTestMapper;
import com.atguigu.gmall.model.product.BaseUserTest;
import com.atguigu.gmall.service.BaseUserTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseUserTestServiceImpl extends ServiceImpl<BaseUserTestMapper, BaseUserTest> implements BaseUserTestService {
}
