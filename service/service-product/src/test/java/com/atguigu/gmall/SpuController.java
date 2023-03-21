package com.atguigu.gmall;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.mapper.BaseUserTestMapper;
import com.atguigu.gmall.model.product.BaseUserTest;
import com.atguigu.gmall.service.BaseUserTestService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpuController {

    @Autowired
    private BaseUserTestService baseUserTestService;

    @Test
    public void test(){
        LambdaQueryWrapper<BaseUserTest> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BaseUserTest::getName,"陈东宇");
        List<BaseUserTest> list = baseUserTestService.list(lambdaQueryWrapper);
        for (BaseUserTest baseUserTest : list) {
            baseUserTest.setAddress("深圳");
        }
        baseUserTestService.updateBatchById(list);
    }

}
