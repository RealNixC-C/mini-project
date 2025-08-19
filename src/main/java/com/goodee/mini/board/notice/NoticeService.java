package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.mini.board.BoardService;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public List<NoticeVO> list() {
		return noticeDao.list();
	}
	
}
