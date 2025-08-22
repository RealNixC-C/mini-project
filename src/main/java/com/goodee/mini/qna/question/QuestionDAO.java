package com.goodee.mini.qna.question;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDAO {
	
	public List<QuestionVO> list() throws Exception;
	
	public int totalCount() throws Exception;
	
	public QuestionVO detail(QuestionVO questionVO) throws Exception;
	
	public int insert(QuestionVO questionVO) throws Exception;
	
	public int delete(QuestionVO questionVO) throws Exception;
}
