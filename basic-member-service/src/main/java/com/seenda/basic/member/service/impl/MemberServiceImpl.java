package com.seenda.basic.member.service.impl;

import com.seenda.basic.member.dao.MemberMapper;
import com.seenda.basic.member.entity.Member;
import com.seenda.basic.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member findById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addMember(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public Integer modifyMember(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Integer removeMemberById(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }
}
