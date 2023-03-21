package com.atguigu.gmall.biz;

import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.ui.Model;

import java.util.List;

public interface CategoryBizService {

    List<CategoryVo> categoryAll();
}
