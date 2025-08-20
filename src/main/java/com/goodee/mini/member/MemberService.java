package com.goodee.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public boolean hasMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		
		boolean check = false;
		// check: true  => 검증 실패
		// check: false => 검증 통과
		
		check = bindingResult.hasErrors();
		
		if(!memberVO.getMemPass().equals(memberVO.getMemPassCheck())) {
			check = true;
			bindingResult.rejectValue("memPassCheck", "", "비밀번호가 일치하지 않습니다.");
		}
		
		// ID 중복 검사
		MemberVO memberCheck = memberDAO.login(memberVO);
		
		if (memberCheck != null) {
			check = true;
			bindingResult.rejectValue("username", "", "이미 등록되어 있는 ID입니다.");
		}
		return check;
	}
	
	public int join(MemberVO memberVO) throws Exception {
		return memberDAO.join(memberVO);
	}
}
