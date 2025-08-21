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
		
		//세션멤버에는 기존정보가 다 있음
		//System.out.println("sessionMember 세션정보:"+sessionMember.toString());
		
		if(bindingResult.hasErrors()) {
			return "member/mypage";
		}

		//유효성 검증 후, 에러가 없다면 실행
		//memberVO에는 아이디비번이 없고, 변경된 내용값만 가지고있음
		//System.out.println("mypage에서 받아온 멤버객체:"+memberVO.toString());
		//모든정보를 가지고있는 세션멤버에 변경된정보를 가지고있는 멤버객체의 변경값을 넣어줌
		sessionMember.setMemName(memberVO.getMemName()); //이름
		sessionMember.setMemEmail(memberVO.getMemEmail()); //이메일
		sessionMember.setMemPhone(memberVO.getMemPhone()); //전화번호
		sessionMember.setMemBirth(memberVO.getMemBirth()); //생년월일
		sessionMember.setMemAddress(memberVO.getMemAddress()); //주소
		
		//변경된 값을 다 갖게된 세션멤버를 업데이트에 보내줌
		int result = memberService.updateInfo(sessionMember);
		//세션에 업데이트된 세션멤버를 다시 넣어줌
		session.setAttribute("member", sessionMember);
		
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
	public void changePass(MemberVO memberVO) throws Exception {}
	
	@PostMapping("changePass")
	public void changePass(@Validated({UpdateGroup.class}) MemberVO memberVO, BindingResult bindingResult, HttpSession session, Model model) throws Exception {
		MemberVO sessionMember =(MemberVO)session.getAttribute("member");
		System.out.println("세션에 담긴 객체정보: "+sessionMember.toString());
		
		//현재 비밀번호가 일치하는지 확인하기
		if (sessionMember.getMemPass().equals(memberVO.getMemPass())) {
			bindingResult.rejectValue("memPass", "", "이미 등록되어 있는 ID입니다.");
		}
		
		//비밀번호 유효성 및 확인비번과 일치하는지 확인
		
		//새로운 비번으로 업데이트 해주기
		
		//세션 객체에 반영해주기
		
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
