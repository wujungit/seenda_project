package com.seenda.basic.member.dao;

import com.seenda.basic.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

public interface MemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}