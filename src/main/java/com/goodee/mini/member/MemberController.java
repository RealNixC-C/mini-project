package com.goodee.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.goodee.mini.board.notice.NoticeController;
import com.goodee.mini.home.HomeController;
import com.goodee.mini.member.validation.AddGroup;
import com.goodee.mini.member.validation.UpdateGroup;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/member/*")
@Slf4j
public class MemberController {

    private final NoticeController noticeController;

    private final HomeController homeController;

	@Autowired
	private MemberService memberService;

    MemberController(HomeController homeController, NoticeController noticeController) {
        this.homeController = homeController;
        this.noticeController = noticeController;
    }
	
	@GetMapping("join")
	public void join(MemberVO memberVO) throws Exception {
		
	}
	
	@PostMapping("join")
	public String join(@Validated({AddGroup.class, UpdateGroup.class}) MemberVO memberVO, BindingResult bindingResult, Model model) throws Exception {
		
		boolean check = memberService.hasMemberError(memberVO, bindingResult);
		
		if(check) {
			return "member/join";
		}
		
		int result = memberService.join(memberVO);
		
		String msg = "회원가입 처리중 오류가 발생했습니다.";
		
		if(result > 0) {
			msg = "회원가입이 완료되었습니다.";
		}
		
		String url = "/";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@GetMapping("login")
	public void login(MemberVO memberVO) throws Exception {
		
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session, Model model) throws Exception{
		memberVO = memberService.login(memberVO);
		
		if(memberVO != null) {
			if(memberVO.isEnable()) {
				session.setAttribute("member", memberVO);
			} else {
				model.addAttribute("msg", "가입되지 않은 아이디입니다.");
				model.addAttribute("url", "/");
				return "commons/result";
			}
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
	
	@PostMapping("updateInfo")
	public String update(@Validated({UpdateGroup.class}) MemberVO memberVO, BindingResult bindingResult, HttpSession session, Model model) throws Exception {
		
		MemberVO sessionMember =(MemberVO)session.getAttribute("member");
		
		if(bindingResult.hasErrors()) {
			return "member/mypage";
		}

		memberVO.setMemNo(sessionMember.getMemNo());
		memberVO.setMemPass(sessionMember.getMemPass());
		System.out.println(memberVO.toString());
		memberVO = memberService.login(memberVO);
		session.setAttribute("member", memberVO);
		int result = memberService.updateInfo(memberVO);
		
		String msg = "수정중 오류가 발생했습니다.";
		
		if(result > 0) {
			msg = "수정이 완료되었습니다.";
		}
		
		String url = "mypage";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@GetMapping("changePass")
	public void changePass(MemberVO memberVO, Model model) throws Exception {
		model.addAttribute(memberVO);
	}
	
	@PostMapping("changePass")
	public void changePass(@Validated({AddGroup.class, UpdateGroup.class}) MemberVO memberVO, BindingResult bindingResult, Model model) throws Exception {
//		memberVO = memberService.login(memberVO);
	}
	
	//post 매핑으로 바꾸기
	@GetMapping("deleteMem")
	public String deleteMem(HttpSession session, Model model) throws Exception {
		MemberVO memberVO =(MemberVO)session.getAttribute("member");
		int result = memberService.deleteMem(memberVO);
		session.invalidate();
		
		String msg = "탈퇴 처리중 오류가 발생했습니다.";
		
		if(result > 0) {
			msg = "탈퇴가 완료되었습니다.";
		}
		
		String url = "/";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
}
