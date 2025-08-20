package com.goodee.mini.question;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDAO {
	
	public List<QuestionVO> list();
	
	public int totalCount();
	
}
