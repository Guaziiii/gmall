package com.atguigu.gmall.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SkuJsonVo {
    @TableId("sku_id")
    String skuId;

    @TableField("sku_values")
    String skuValues;

}
