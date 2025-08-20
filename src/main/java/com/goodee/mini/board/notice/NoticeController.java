package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.BoardVO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
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
	public String add(@ModelAttribute("boardVO") BoardVO boardVO) throws Exception {
		
		return "notice/add";
	}
	
//	@PostMapping("add")
//	public String add(Model model, @Valid BoardVO boardVO) throws Exception {
//		
//	}
	
	@PostMapping("boardFile")
	@ResponseBody
	public String boardFile(MultipartFile image) throws Exception {
		
		return noticeService.boardFile(image);
	}
	
	
}
