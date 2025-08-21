package com.goodee.mini.qna.reply;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReplyVO {
	
	private Long replyNo;
	private Long memNo;
	private Long questNo;
	private String replyContent;
	private LocalDate replyDate;
	
}
