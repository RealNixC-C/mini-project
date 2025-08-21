package com.goodee.mini.pet;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.mini.commons.pager.Pager;

@Mapper
public interface PetDao {

	public List<PetVO> list(Pager pager) throws Exception;
	public Long totalCount(Pager pager) throws Exception;
	public int add(PetVO petVO) throws Exception;
	public PetVO detail(PetVO petVO) throws Exception;
	public int update(PetVO petVO) throws Exception;
	public int delete(PetVO petVO) throws Exception;
	public int addFile(PetFileVO petFileVO) throws Exception;
	public PetFileVO fileDetail(PetFileVO petFileVO) throws Exception;
	public int fileDelete(PetFileVO petFileVO) throws Exception;
}
