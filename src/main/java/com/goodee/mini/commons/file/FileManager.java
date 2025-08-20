package com.goodee.mini.commons.file;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public String fileSave(String path ,MultipartFile image) throws Exception {
		
		// 디렉토리 생성
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 파일명 생성
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + image.getOriginalFilename();
		
		// 파일 저장
		image.transferTo(file);
		
		return fileName;
	}
	
	// 파일 삭제
	public boolean fileDelete(String path, String fileName) throws Exception {
		File file = new File(path, fileName);
		
		return file.delete();
	}
	
}
