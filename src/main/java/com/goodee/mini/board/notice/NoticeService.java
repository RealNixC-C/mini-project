package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.BoardService;
import com.goodee.mini.board.BoardVO;
import com.goodee.mini.commons.file.FileManager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload")
	private String upload;
	
	@Value("${board.notice}")
	private String board;
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return noticeDao.list();
	}
	
	@Override
	public NoticeVO detail(BoardVO boardVO) throws Exception {
		return noticeDao.detail(boardVO);
	}
	
	@Override
	public String boardFile(MultipartFile image) throws Exception {
		if(image == null || image.getSize() == 0) return null;
		String fileName = fileManager.fileSave(upload + board, image);
		
		return "";
	}
	
}
