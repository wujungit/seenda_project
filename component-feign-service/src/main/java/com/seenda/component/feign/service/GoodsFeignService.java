package com.seenda.component.feign.service;

import com.seenda.basic.common.dto.goods.GoodsDTO;
import com.seenda.basic.common.vo.goods.GoodsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "basic-goods-service")
public interface GoodsFeignService {

    @GetMapping("/goods/findGoodsById/{id}")
    public GoodsVO findGoodsById(@PathVariable("id") Long id);

    @PostMapping("/goods/addGoods")
    public void addGoods(@RequestBody GoodsDTO dto);

    @PutMapping("/goods/modifyGoods")
    public void modifyGoods(@RequestBody GoodsDTO dto);

    @DeleteMapping("/goods/removeGoods/{id}")
    public void removeGoods(@PathVariable("id") Long id);

}
