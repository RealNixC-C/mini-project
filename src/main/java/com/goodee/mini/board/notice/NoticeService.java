package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.mini.board.BoardService;
import com.goodee.mini.board.BoardVO;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return noticeDao.list();
	}
	
	@Override
	public NoticeVO detail(BoardVO boardVO) throws Exception {
		return noticeDao.detail(boardVO);
	}
	
}
