package com.atguigu.gmall.mapper;


import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author guazi
* @description 针对表【base_attr_info(属性表)】的数据库操作Mapper
* @createDate 2022-12-04 23:53:08
* @Entity com.atguigu.gmall.domain.BaseAttrInfo
*/
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    List<BaseAttrInfo> getAttrValueByCategoryLevel(Long c1id, Long c2id, Long c3id);
}




