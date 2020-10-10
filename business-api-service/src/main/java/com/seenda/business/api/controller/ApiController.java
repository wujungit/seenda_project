package com.seenda.business.api.controller;

import com.seenda.basic.common.base.BaseResult;
import com.seenda.basic.common.dto.goods.GoodsDTO;
import com.seenda.basic.common.dto.member.MemberDTO;
import com.seenda.component.feign.service.GoodsFeignService;
import com.seenda.component.feign.service.MemberFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MemberFeignService memberFeignService;

    @Autowired
    private GoodsFeignService goodsFeignService;

    @GetMapping("/testSeata")
    @GlobalTransactional
    public BaseResult testSeata() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setSerial("seenda");
        memberFeignService.addMember(memberDTO);

        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setSerial("seenda");
        goodsFeignService.addGoods(goodsDTO);

        return BaseResult.buildSuccess("test seata success", Boolean.TRUE);
    }

}
