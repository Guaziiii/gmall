package com.atguigu.gmall.front.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.feign.product.CategoryFeignClient;
import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CategoryFeignClient categoryFeignClient;

    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){
        Result<List<CategoryVo>> result = categoryFeignClient.categoryAll();
        List<CategoryVo> list = result.getData();
        model.addAttribute("list",list);
        return "index/index";
    }


}
