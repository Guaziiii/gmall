package com.atguigu.gmall.mapper;


import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.vo.CategoryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.ui.Model;

import java.util.List;

/**
* @author guazi
* @description 针对表【base_category1(一级分类表)】的数据库操作Mapper
* @createDate 2022-12-04 23:53:08
* @Entity com.atguigu.gmall.domain.BaseCategory1
*/
public interface BaseCategory1Mapper extends BaseMapper<BaseCategory1> {

    List<CategoryVo> categoryAll();
}




