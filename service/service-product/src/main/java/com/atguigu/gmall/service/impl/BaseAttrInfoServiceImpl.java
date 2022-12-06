package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.service.BaseAttrInfoService;
import com.atguigu.gmall.service.BaseAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo> implements BaseAttrInfoService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueService baseAttrValueService;

    @Autowired
    BaseAttrInfoService baseAttrInfoService;


    @Override
    public List<BaseAttrInfo> getAttrValueByCategoryLevel(Long c1id, Long c2id, Long c3id) {
        return baseAttrInfoMapper.getAttrValueByCategoryLevel(c1id,c2id,c3id);
    }

    @Transactional
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        baseAttrInfoMapper.insert(baseAttrInfo);

        List<BaseAttrValue> list = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value : list) {
            value.setAttrId(baseAttrInfo.getId());
        }
        baseAttrValueService.saveBatch(list);
    }

    @Transactional
    @Override
    public void updateAttrInfoAndValue(BaseAttrInfo baseAttrInfo) {
        baseAttrInfoService.updateById(baseAttrInfo);

        //1.baseAttrValue 没有id新增
        List<BaseAttrValue> valueList = baseAttrInfo.getAttrValueList();
        //记录传入的attrValue包含id的对象
        ArrayList<Long> ids = new ArrayList<>();
        for (BaseAttrValue value : valueList) {
            //新增
            if (value.getId()==null){
                value.setAttrId(baseAttrInfo.getId());
                baseAttrValueService.save(value);
            }
            //修改
            if (value.getId()!=null){
                baseAttrValueService.updateById(value);
                ids.add(value.getId());
            }
        }

        //删除  delete * from base_attr_value where attr_id = {x} and id not in (ids)
        if (ids.size()>0){
            LambdaQueryWrapper<BaseAttrValue> wrapper = new LambdaQueryWrapper<BaseAttrValue>().eq(BaseAttrValue::getAttrId, baseAttrInfo.getId()).notIn(BaseAttrValue::getId, ids);
            baseAttrValueService.remove(wrapper);
        }else {
            baseAttrValueService.remove(new LambdaQueryWrapper<BaseAttrValue>().eq(BaseAttrValue::getAttrId,baseAttrInfo.getId()));
        }
    }
}
