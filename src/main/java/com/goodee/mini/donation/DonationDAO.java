package com.goodee.mini.donation;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationDAO {
	
	public DonationVO selectRecent(DonationVO donationVO) throws Exception;
	
	public int insert(DonationVO donationVO) throws Exception;
	
	
}
