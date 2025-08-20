package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.BoardVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/notice/*")
@Slf4j
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
		
		boardVO = noticeService.detail(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return "notice/detail";
	}
	
	@GetMapping("add")
	public String add(@ModelAttribute("boardVO") BoardVO boardVO) throws Exception {
		
		return "notice/add";
	}
	
	@PostMapping("add")
	public String add(Model model, @Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile image) throws Exception {
		
		if (bindingResult.hasErrors()) {
			return "notice/add";
		}
		noticeService.add(boardVO, image);
		
		return "notice/detail?boardNo" + boardVO.getBoardNo();
	}
	
	@PostMapping("boardFile")
	@ResponseBody
	public String boardFile(MultipartFile image) throws Exception {
		
		log.info("{}", image.getName());
		System.out.println("boardFile들어옴");
		
		return noticeService.boardFile(image);
	}
	
	
}
