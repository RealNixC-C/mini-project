package com.goodee.mini.qna.question;

import java.time.LocalDate;

import com.goodee.mini.board.BoardVO;
import com.goodee.mini.member.MemberVO;
import com.goodee.mini.qna.reply.ReplyVO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QuestionVO extends BoardVO{
	
	private Long questNo;
	private Long memNo;
	@NotBlank(message = "제목은 필수입니다.")
	private String questTitle;
	private String questContent;
	private LocalDate questDate;
	private Long questHit;
	private boolean visible;
	
	private MemberVO memberVO;
	private ReplyVO replyVO;
	
}
