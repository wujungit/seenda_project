package com.seenda.component.feign.service;

import com.seenda.basic.common.dto.member.MemberDTO;
import com.seenda.basic.common.vo.member.MemberVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "basic-member-service")
public interface MemberFeignService {

    @GetMapping("/member/findMemberById/{id}")
    public MemberVO findMemberById(@PathVariable("id") Long id);

    @PostMapping("/member/addMember")
    public void addMember(@RequestBody MemberDTO dto);

    @PutMapping("/member/modifyMember")
    public void modifyMember(@RequestBody MemberDTO dto);

    @DeleteMapping("/member/removeMember/{id}")
    public void removeMember(@PathVariable("id") Long id);

}
