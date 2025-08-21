package com.goodee.mini.qna.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDAO questionDAO;
	
	public List<QuestionVO> list() throws Exception{
		return questionDAO.list();
	}
	
	public int delete(QuestionVO questionVO) throws Exception {
		return questionDAO.delete(questionVO);
	}
	
}
