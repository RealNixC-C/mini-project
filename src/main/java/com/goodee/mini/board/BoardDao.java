package com.goodee.mini.board;

import java.util.List;

import com.goodee.mini.board.notice.NoticeVO;

public interface BoardDao {
	
	public List<NoticeVO> list();

}
