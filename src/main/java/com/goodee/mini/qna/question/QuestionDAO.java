package com.goodee.mini.qna.question;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDAO {
	
	public List<QuestionVO> list();
	
	public int totalCount();
	
	public int delete(QuestionVO questionVO);
}
