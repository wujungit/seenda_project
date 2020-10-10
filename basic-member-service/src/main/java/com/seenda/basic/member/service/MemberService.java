package com.seenda.basic.member.service;

import com.seenda.basic.member.entity.Member;

public interface MemberService {

    Member findById(Long id);

    Integer addMember(Member member);

    Integer modifyMember(Member member);

    Integer removeMemberById(Long id);

}
