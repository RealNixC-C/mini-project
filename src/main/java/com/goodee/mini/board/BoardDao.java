package com.goodee.mini.board;

import java.util.List;

import com.goodee.mini.board.notice.NoticeVO;

public interface BoardDao {
	
	public List<NoticeVO> list() throws Exception;
	public BoardVO detail(BoardVO boardVO) throws Exception;
	public int add(BoardVO boardVO) throws Exception;
	public int addFile(BoardFileVO boardFileVO) throws Exception;
	public int fileDelete(BoardFileVO boardFileVO) throws Exception;
	public BoardFileVO fileDetail(BoardFileVO boardFileVO) throws Exception;
	public int update(BoardVO boardVO) throws Exception;
	public int delete(BoardVO boardVO) throws Exception;
}
