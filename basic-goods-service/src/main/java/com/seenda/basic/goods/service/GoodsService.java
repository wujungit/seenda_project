package com.seenda.basic.goods.service;

import com.seenda.basic.goods.entity.Goods;

public interface GoodsService {

    Goods findById(Long id);

    Integer addGoods(Goods goods);

    Integer modifyGoods(Goods goods);

    Integer removeGoodsById(Long id);

}
