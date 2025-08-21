package com.goodee.mini.pet;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetDao {

	public List<PetVO> list() throws Exception;
	
}
