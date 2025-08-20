package com.goodee.mini.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.notice.NoticeVO;

public interface BoardService {
	
	public List<NoticeVO> list() throws Exception;
	public NoticeVO detail(BoardVO boardVO) throws Exception;
	public String boardFile(MultipartFile image) throws Exception;

}
