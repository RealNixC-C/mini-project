package com.goodee.mini.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	
	public int join(MemberVO memberVO) throws Exception;
	
	public MemberVO login(MemberVO memberVO) throws Exception;
}
