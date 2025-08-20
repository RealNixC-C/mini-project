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
			System.out.println("비밀번호 확인: "+memberVO.getMemPass()+memberVO.getMemPassCheck()+check);
			check = true;
			bindingResult.rejectValue("memPassCheck", "", "비밀번호가 일치하지 않습니다.");
		}
		
		// ID 중복 검사
		MemberVO memberCheck = memberDAO.login(memberVO);
		
		if (memberCheck != null) {
			check = true;
			bindingResult.rejectValue("memId", "", "이미 등록되어 있는 ID입니다.");
		}
		return check;
	}
	
	public int join(MemberVO memberVO) throws Exception {
		return memberDAO.join(memberVO);
	}
	
	public MemberVO login(MemberVO memberVO) throws Exception{
		MemberVO checkVO = memberDAO.login(memberVO);
		
		if(checkVO != null && memberVO.getMemPass().equals(checkVO.getMemPass())) {
			return checkVO;
		}
		
		return null;
	}
	
	public int updateInfo(MemberVO memberVO) throws Exception{
		int result = memberDAO.updateInfo(memberVO);
		System.out.println(result);
		return result;
	}
	
//	public int updatePass(MemberVO memberVO) throws Exception{
//		return memberDAO.updatePass(memberVO);
//	}
	
	public int deleteMem(MemberVO memberVO) throws Exception{
		return memberDAO.deleteMem(memberVO);
	}
}
