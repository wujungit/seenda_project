package com.seenda.basic.goods.controller;

import com.seenda.basic.common.dto.goods.GoodsDTO;
import com.seenda.basic.common.vo.goods.GoodsVO;
import com.seenda.basic.goods.entity.Goods;
import com.seenda.basic.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService GoodsService;

    @GetMapping("/findGoodsById/{id}")
    public GoodsVO findGoodsById(@PathVariable("id") Long id) {
        log.info("findMemberById...8104");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Goods Goods = GoodsService.findById(id);
        GoodsVO vo = new GoodsVO();
        vo.setId(Goods.getId());
        vo.setSerial(Goods.getSerial());
        return vo;
    }

    @PostMapping("/addGoods")
    public void addGoods(@RequestBody GoodsDTO dto) {
        Goods Goods = new Goods();
        Goods.setId(dto.getId());
        Goods.setSerial(dto.getSerial());
        GoodsService.addGoods(Goods);
    }

    @PutMapping("/modifyGoods")
    public void modifyGoods(@RequestBody GoodsDTO dto) {
        Goods Goods = new Goods();
        Goods.setId(dto.getId());
        Goods.setSerial(dto.getSerial());
        GoodsService.modifyGoods(Goods);
    }

    @DeleteMapping("/removeGoods/{id}")
    public void removeGoods(@PathVariable("id") Long id) {
        GoodsService.removeGoodsById(id);
    }

}
