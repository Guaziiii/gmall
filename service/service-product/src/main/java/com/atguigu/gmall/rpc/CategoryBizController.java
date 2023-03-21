package com.atguigu.gmall.rpc;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.biz.CategoryBizService;
import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rpc/inner/product")
public class CategoryBizController {

    @Autowired
    CategoryBizService categoryBizService;

    @GetMapping("/categorys/all")
    public Result<List<CategoryVo>> categoryAll(){

        List<CategoryVo> vos  = categoryBizService.categoryAll();

        return Result.ok(vos);

    }

}
