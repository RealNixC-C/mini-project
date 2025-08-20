package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.BoardFileVO;
import com.goodee.mini.board.BoardService;
import com.goodee.mini.board.BoardVO;
import com.goodee.mini.commons.file.FileManager;

@Service
@Transactional
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${app.temp}")
	private String temp;
	
	@Value("${board.notice}")
	private String board;
	
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return noticeDao.list();
	}
	
	@Override
	public int add(BoardVO boardVO, MultipartFile image) throws Exception {
		int result = noticeDao.add(boardVO);
		
		if(image != null && !image.isEmpty()) {
			String fileName = fileManager.fileSave(upload + board, image);
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setOriName(image.getOriginalFilename());
			boardFileVO.setSaveName(fileName);
			boardFileVO.setBoardNo(boardVO.getBoardNo());
			result = noticeDao.addFile(boardFileVO);
		}
		
		return result;
	}
	
	
	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return noticeDao.detail(boardVO);
	}
	
	@Override
	public int update(BoardVO boardVO, MultipartFile image) throws Exception {
		int result = noticeDao.update(boardVO);
		
		if(image != null && !image.isEmpty()) {
			String fileName = fileManager.fileSave(upload + board, image);
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setOriName(image.getOriginalFilename());
			boardFileVO.setSaveName(fileName);
			boardFileVO.setBoardNo(boardVO.getBoardNo());
			result = noticeDao.addFile(boardFileVO);
		}
		return result;
	}
	
	@Override
	public int delete(BoardVO boardVO) throws Exception {
		boardVO = noticeDao.detail(boardVO);
		
		if(boardVO.getBoardFileVO() != null) {
			boolean isDeleted = fileManager.fileDelete(upload + board, boardVO.getBoardFileVO().getSaveName());
		}
		int result = noticeDao.fileDelete(boardVO.getBoardFileVO());

		return noticeDao.delete(boardVO);
	}
	
	@Override
	public String boardFile(MultipartFile image) throws Exception {
		if(image == null || image.isEmpty()) return null;
		String fileName = fileManager.fileSave(upload + temp, image);
		
		return "/files" + temp + "/" + fileName;
	}
	
	@Override
	public int fileDelete(BoardFileVO boardFileVO) throws Exception {
		boardFileVO = noticeDao.fileDetail(boardFileVO);
		boolean result = fileManager.fileDelete(upload + board, boardFileVO.getSaveName());
		if(!result) return 0;
		
		return noticeDao.fileDelete(boardFileVO);
	}
	
	
	
	
	
	
	
	
	
}
