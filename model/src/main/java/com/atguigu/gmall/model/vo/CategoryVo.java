package com.atguigu.gmall.model.vo;


import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {

    public Long categoryId;

    public String categoryName;

    public List<CategoryVo> categoryChild;

}
