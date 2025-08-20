package com.goodee.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodee.mini.member.validation.AddGroup;
import com.goodee.mini.member.validation.UpdateGroup;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join(MemberVO memberVO) throws Exception {
		
	}
	
	@PostMapping("join")
	public String join(@Validated({AddGroup.class, UpdateGroup.class}) MemberVO memberVO, BindingResult bindingResult) throws Exception {
		
		boolean check = memberService.hasMemberError(memberVO, bindingResult);
		
		if(check) {
			return "member/join";
		}
		
		int result = memberService.join(memberVO);
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login(MemberVO memberVO) throws Exception {
		
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = memberService.login(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public void mypage(MemberVO memberVO) throws Exception {
	}
	
	@GetMapping("changePass")
	public void changePass(MemberVO memberVO) throws Exception {
		
	}
	
	
}
