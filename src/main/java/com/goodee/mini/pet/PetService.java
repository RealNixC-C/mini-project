package com.goodee.mini.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	PetDao petDao;
	
	public List<PetVO> list() throws Exception {
		return petDao.list();
		
	}
	
}
