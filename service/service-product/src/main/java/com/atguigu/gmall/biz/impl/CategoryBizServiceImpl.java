package com.atguigu.gmall.biz.impl;

import com.atguigu.gmall.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.biz.CategoryBizService;
import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CategoryBizServiceImpl implements CategoryBizService {

    @Autowired
    BaseCategory1Mapper baseCategory1Mapper;


    @Override
    public List<CategoryVo> categoryAll() {

        List<CategoryVo> vos =  baseCategory1Mapper.categoryAll();
        return vos;
    }
}
