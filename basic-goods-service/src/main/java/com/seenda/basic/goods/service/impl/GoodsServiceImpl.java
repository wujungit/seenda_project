package com.seenda.basic.goods.service.impl;

import com.seenda.basic.goods.dao.GoodsMapper;
import com.seenda.basic.goods.entity.Goods;
import com.seenda.basic.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods findById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Integer modifyGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public Integer removeGoodsById(Long id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }
}
