package com.goodee.mini.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.mini.board.BoardFileVO;
import com.goodee.mini.board.BoardVO;
import com.goodee.mini.commons.pager.Pager;
import com.goodee.mini.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Model model, Pager pager) throws Exception {
		List<NoticeVO> list = noticeService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "notice/list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, BoardVO boardVO) throws Exception {
		boardVO = noticeService.detail(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return "notice/detail";
	}
	
	@GetMapping("add")
	public String add(BoardVO boardVO) throws Exception {
		
		return "notice/add";
	}
	
	@PostMapping("add")
	public String add(Model model, @Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile image, HttpSession session) throws Exception {
		if (bindingResult.hasErrors()) {
			return "notice/add";
		}
		// 세션에서 작성자 꺼내와서 넣음
		MemberVO member = (MemberVO)session.getAttribute("member");
		boardVO.setMemNo(member.getMemNo());
		int result = noticeService.add(boardVO, image);
		
		String msg = "등록 실패";
		if(result > 0) {
			msg = "등록 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", "./list");
		
		return "commons/result";
	}
	
	@GetMapping("update")
	public String update(Model model, BoardVO boardVO) throws Exception {
		boardVO = noticeService.detail(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return "notice/add";
	}
	
	@PostMapping("update")
	public String update(Model model, @Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile image) throws Exception {
		if (bindingResult.hasErrors()) {
			return "notice/update";
		}
		int result = noticeService.update(boardVO, image);
		String msg = "수정 실패";
		if(result > 0) {
			msg = "수정 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", "./detail?boardNo=" + boardVO.getBoardNo());
		
		return "commons/result";
	}
	
	@PostMapping("delete")
	public String delete(Model model, BoardVO boardVO) throws Exception {
		int result = noticeService.delete(boardVO);
		
		String msg = "삭제 실패";
		if(result > 0) { 
			msg = "삭제 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", "./list");
		
		return "commons/result";
	}
	
	@PostMapping("boardFile")
	@ResponseBody
	public String boardFile(MultipartFile image) throws Exception {
		
		return noticeService.boardFile(image);
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int fileDelete(BoardFileVO boardFileVO) throws Exception {
		return noticeService.fileDelete(boardFileVO);
	}

}
