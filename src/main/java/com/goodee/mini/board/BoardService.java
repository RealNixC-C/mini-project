package com.goodee.mini.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.notice.NoticeVO;
import com.goodee.mini.commons.pager.Pager;

public interface BoardService {
	
	public List<NoticeVO> list(Pager pgaer) throws Exception;
	public BoardVO detail(BoardVO boardVO) throws Exception;
	public String boardFile(MultipartFile image) throws Exception;
	public int add(BoardVO boardVO, MultipartFile image) throws Exception;
	public int update(BoardVO boardVO, MultipartFile image) throws Exception;
	public int fileDelete(BoardFileVO boardFileVO) throws Exception;
	public int delete(BoardVO boardVO) throws Exception;
}
