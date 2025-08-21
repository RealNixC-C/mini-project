package com.goodee.mini.pet;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.BoardFileVO;
import com.goodee.mini.commons.file.FileManager;
import com.goodee.mini.commons.pager.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class PetService {

	@Autowired
	private PetDao petDao;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${board.pet}")
	private String board;

	public List<PetVO> list(Pager pager) throws Exception {
		Long totalCount = petDao.totalCount(pager);
		if(totalCount == 0) return Collections.emptyList();
		pager.setPerPage(8L);
		pager.makeNum(totalCount);
		
		return petDao.list(pager);
	}
	
	public int add(PetVO petVO, MultipartFile image) throws Exception {
		int result = petDao.add(petVO);
		
		if(image != null && !image.isEmpty()) {
			String fileName = fileManager.fileSave(upload + board, image);
			PetFileVO petFileVO = new PetFileVO();
			petFileVO.setOriName(image.getOriginalFilename());
			petFileVO.setSaveName(fileName);
			petFileVO.setPetNo(petVO.getPetNo());
			result = petDao.addFile(petFileVO);
		}
		return result;
	}
	
	public PetVO detail(PetVO petVO) throws Exception {
		
		return petDao.detail(petVO); 
	}
	
	public int update(PetVO petVO, MultipartFile image) throws Exception {
		int result = petDao.update(petVO);
		
		if(image != null && !image.isEmpty()) {
			String fileName = fileManager.fileSave(upload + board, image);
			PetFileVO petFileVO = new PetFileVO();
			petFileVO.setOriName(image.getOriginalFilename());
			petFileVO.setSaveName(fileName);
			petFileVO.setPetNo(petVO.getPetNo());
			result = petDao.addFile(petFileVO);
		}
		return result;
	}
	
	public int delete(PetVO petVO) throws Exception {
		petVO = petDao.detail(petVO);
		if(petVO.getPetFileVO() != null) {
			boolean result = fileManager.fileDelete(upload + board, petVO.getPetFileVO().getSaveName());
		}
		int result = petDao.fileDelete(petVO.getPetFileVO());
		
		return petDao.delete(petVO);
	}
	
	public int fileDelete(PetFileVO petFileVO) throws Exception {
		petFileVO = petDao.fileDetail(petFileVO);
		boolean result = fileManager.fileDelete(upload + board, petFileVO.getSaveName());
		if(!result) return 0;
		
		return petDao.fileDelete(petFileVO);
	}
	
	
	
}
