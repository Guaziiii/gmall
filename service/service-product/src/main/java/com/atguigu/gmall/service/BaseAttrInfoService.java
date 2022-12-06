package com.atguigu.gmall.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BaseAttrInfoService extends IService<BaseAttrInfo> {
    /**
     * 根据传入的三个id查询具体属性
     * @param c1id
     * @param c2id
     * @param c3id
     * @return
     */
    List<BaseAttrInfo> getAttrValueByCategoryLevel(Long c1id, Long c2id, Long c3id);

    /**
     * 根据传入的信息保存对应层级的对应属性
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 修改平台属性
     * @param baseAttrInfo
     */
    void updateAttrInfoAndValue(BaseAttrInfo baseAttrInfo);
}
