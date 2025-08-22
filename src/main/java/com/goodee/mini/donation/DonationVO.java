package com.goodee.mini.donation;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DonationVO {
	
	private Long donateNo;
	private Long memNo;
	private Long donateAmount;
	private LocalDate donateDate;
	
	
}
