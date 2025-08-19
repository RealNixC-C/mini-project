package com.goodee.mini.board;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardVO {

	private Long boardNo;
	private Long memNo;
	private String boardTitle;
	private String boardContent;
	private LocalDate boardDate;
	private Long boardHit;
	
}
