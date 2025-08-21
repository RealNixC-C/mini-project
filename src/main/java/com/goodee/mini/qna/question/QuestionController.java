package com.goodee.mini.qna.question;

import java.util.List;

import com.goodee.mini.home.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/question/*")
public class QuestionController {

    private final HomeController homeController;

	@Autowired
	private QuestionService questionService;

    QuestionController(HomeController homeController) {
        this.homeController = homeController;
    }
	
	@GetMapping("list")
	public String list(Model model) throws Exception{
		List<QuestionVO> list = questionService.list();
		
//		for (QuestionVO question : list) {
//		    int memberNo = question.getMemNo();
//
//		    // 예: member 정보 가져오기
//		    MemberVO member = memberService.login(memberNo);
//
//		    // QuestionVO에 MemberVO를 담는 setter가 있다고 가정
//		    question.setMember(member);
//		}
		System.out.println(list);
		model.addAttribute("list", list);
		return "question/list";
	}
	
	@PostMapping("delete")
	public String delete(QuestionVO questionVO) throws Exception{
		return "";
	}
	
}
