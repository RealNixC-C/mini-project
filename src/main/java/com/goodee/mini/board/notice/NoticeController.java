package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodee.mini.board.BoardVO;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<NoticeVO> list = noticeService.list();
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, BoardVO boardVO) throws Exception {
		
		NoticeVO noticeVO = noticeService.detail(boardVO);
		model.addAttribute("noticeVO", noticeVO);
		
		return "notice/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		
		return "notice/add";
	}
	
//	@PostMapping("add")
//	public String add(Model model, @Valid BoardVO boardVO) throws Exception {
//		
//	}
	
	@GetMapping("alert")
	public String alert(Model model) throws Exception {
		
		model.addAttribute("msg", "알람창 확인");
		model.addAttribute("url", "/notice/list");
		
		return "commons/result";
	}
	
}
