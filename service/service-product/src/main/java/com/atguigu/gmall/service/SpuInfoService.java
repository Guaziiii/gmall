package com.atguigu.gmall.service;


import com.atguigu.gmall.model.product.SpuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SpuInfoService extends IService<SpuInfo> {
    /**
     * spuinfo的保存
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);
}
