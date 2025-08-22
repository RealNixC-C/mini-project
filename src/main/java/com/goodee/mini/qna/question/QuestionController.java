package com.goodee.mini.qna.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.goodee.mini.donation.DonationController;
import com.goodee.mini.home.HomeController;
import com.goodee.mini.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value="/question/*")
public class QuestionController {

    private final DonationController donationController;

    private final HomeController homeController;

	@Autowired
	private QuestionService questionService;

    QuestionController(HomeController homeController, DonationController donationController) {
        this.homeController = homeController;
        this.donationController = donationController;
    }
	
	@GetMapping("list")
	public String list(Model model) throws Exception{
		List<QuestionVO> list = questionService.list();
		model.addAttribute("list", list);
		return "question/list";
	}
	
	@GetMapping("detail")
	public String detail(QuestionVO questionVO, Model model) throws Exception{
		QuestionVO question = questionService.detail(questionVO);
		model.addAttribute("question", question);
		return "question/detail";
	}
	
	@GetMapping("add")
	public void insert(QuestionVO questionVO, Model model) throws Exception {
		model.addAttribute("QuestionVO", new QuestionVO());
	}
	
	@PostMapping("add")
	public String insert(@Valid QuestionVO questionVO, BindingResult bindingResult, HttpSession session, Model model) throws Exception {
		MemberVO sessionMember =(MemberVO)session.getAttribute("member");
		if (sessionMember == null) {
			return "redirect:/";
		}
		questionVO.setMemNo(sessionMember.getMemNo());
		int result = questionService.insert(questionVO);
		
		String msg = "등록중 오류가 발생했습니다.";
		
		if(result > 0) {
			msg = "등록이 완료되었습니다.";
		}
		
		String url = "list";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@PostMapping("delete")
	public String delete(QuestionVO questionVO, Model model) throws Exception{
		System.out.println(questionVO.toString());
		int result = questionService.delete(questionVO);
		
		String msg = "삭제 처리중 오류가 발생했습니다.";
		
		if(result > 0) {
			msg = "삭제가 완료되었습니다.";
		}
		
		String url = "list";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
}
