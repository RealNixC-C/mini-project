package com.goodee.mini.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
	
	@Autowired
	private DonationDAO donationDAO;
	
	public DonationVO selectRecent(DonationVO donationVO) throws Exception{
		return donationDAO.selectRecent(donationVO);
	}
	
	public int insert(DonationVO donationVO) throws Exception {
		return donationDAO.insert(donationVO);
	}
	
}
