package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Model model) {
		List<NoticeVO> list = noticeService.list();
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	
	
	
	
}
