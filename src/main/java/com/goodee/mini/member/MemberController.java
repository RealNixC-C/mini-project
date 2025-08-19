package com.goodee.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join() throws Exception {
		
	}
	
	@PostMapping("join")
	public String join(@Validated MemberVO memberVO, BindingResult bindingResult) throws Exception {
		
		boolean check = memberService.hasMemberError(memberVO, bindingResult);
		
		if(check) {
			return "member/join";
		}
		
		int result = memberService.join(memberVO);
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() throws Exception {
		
	}
	
	@PostMapping("login")
	public String login(HttpSession session, Model model) throws Exception{
		
		return "redirect:/";
	}
}
