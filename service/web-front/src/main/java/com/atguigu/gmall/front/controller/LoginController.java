package com.atguigu.gmall.front.controller;

import com.atguigu.gmall.model.product.SpuInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {


    @GetMapping("/login.html")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/test.html")
    public String test(HttpServletRequest request, Model model){
        request.setAttribute("UserName","chendongyu");
        List<SpuInfo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SpuInfo spuInfo = new SpuInfo();
            spuInfo.setSpuName("瓜子"+i);
            list.add(spuInfo);
        }
        model.addAttribute("list",list);
        return "login";
    }
}
