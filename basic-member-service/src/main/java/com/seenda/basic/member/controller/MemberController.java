package com.seenda.basic.member.controller;

import com.seenda.basic.common.dto.member.MemberDTO;
import com.seenda.basic.common.vo.member.MemberVO;
import com.seenda.basic.member.entity.Member;
import com.seenda.basic.member.service.MemberService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RefreshScope
@Slf4j
@Api(value = "MemberController", tags = {"Member服务API"})
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/findMemberById/{id}")
    public MemberVO findMemberById(@PathVariable("id") Long id) {
        log.info("findMemberById...8103");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Member Member = memberService.findById(id);
        MemberVO vo = new MemberVO();
        vo.setId(Member.getId());
        vo.setSerial(Member.getSerial());
        return vo;
    }

    @PostMapping("/addMember")
    public void addMember(@RequestBody MemberDTO dto) {
        Member Member = new Member();
        Member.setId(dto.getId());
        Member.setSerial(dto.getSerial());
        memberService.addMember(Member);
    }

    @PutMapping("/modifyMember")
    public void modifyMember(@RequestBody MemberDTO dto) {
        Member Member = new Member();
        Member.setId(dto.getId());
        Member.setSerial(dto.getSerial());
        memberService.modifyMember(Member);
    }

    @DeleteMapping("/removeMember/{id}")
    public void removeMember(@PathVariable("id") Long id) {
        memberService.removeMemberById(id);
    }

}
