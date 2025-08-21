package com.goodee.mini.support;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.mini.member.MemberVO;

@Mapper
public interface SupportDao {

	public void save(SupportVO supportVO) throws Exception;
	public SupportVO findByMemNo(MemberVO memberVO) throws Exception;
}
