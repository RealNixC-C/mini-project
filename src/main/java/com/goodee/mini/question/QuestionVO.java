package com.goodee.mini.question;

import java.time.LocalDate;

import com.goodee.mini.board.BoardVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QuestionVO extends BoardVO{
	
	private Long questNo;
	private Long memNo;
	private String questTitle;
	private String questContent;
	private LocalDate questDate;
	private Long questHit;
	private boolean visible;
	
}
