package com.atguigu.gmall.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("category_view")
@Data
public class CategoryViewDo {

    @TableId
    private Long id;
    private String name;

    private Long id2;
    private String name2;

    private Long id3;
    private String name3;

}
