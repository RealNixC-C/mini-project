package com.goodee.mini.qna.question;

import java.time.LocalDate;

import com.goodee.mini.board.BoardVO;
import com.goodee.mini.member.MemberVO;
import com.goodee.mini.qna.reply.ReplyVO;

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
	
	private MemberVO memberVO;
	private ReplyVO replyVO;
	
}
