package com.goodee.mini.board;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardVO {

	private Long boardNo;
	private Long memNo;
	@NotBlank(message = "제목을 입력하세요")
	private String boardTitle;
	private String boardContent;
	private LocalDate boardDate;
	private Long boardHit;
	
	private BoardFileVO boardFileVO;
}
