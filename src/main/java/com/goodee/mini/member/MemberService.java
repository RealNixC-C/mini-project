package com.goodee.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.winter.app.member.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public boolean hasMemberError(MemberVO memberVO, BindingResult bindingResult) {
		
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
		
		return true;
	}
	
	public int join(MemberVO memberVO) {
		return 0;
	}
}
