package com.goodee.mini.pet;

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

import com.goodee.mini.commons.pager.Pager;
import com.goodee.mini.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/pet/*")
@Slf4j
public class PetController {

	@Autowired
	private PetService petService;
	
	@GetMapping("list")
	public String list(Model model, Pager pager) throws Exception {
		List<PetVO> list = petService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "pet/list";
	}
	
	@GetMapping("add")
	public String add(Model model, PetVO petVO) throws Exception {
		
		return "pet/add";
	}
	
	@PostMapping("add")
	public String add(Model model, @Valid PetVO petVO, BindingResult bindingResult, MultipartFile image, HttpSession session) throws Exception {
		if (bindingResult.hasErrors()) {
			return "pet/add";
		}
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		petVO.setMemNo(memberVO.getMemNo());
		int result = petService.add(petVO, image);
		
		String msg = "등록 실패";
		if(result > 0) {
			msg = "등록 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", "./list");
		
		return "commons/result";
	}
	
	@GetMapping("detail")
	public String detail(Model model, PetVO petVO) throws Exception {
		petVO = petService.detail(petVO);
		model.addAttribute("petVO", petVO);
		
		return "pet/detail";
	}
	
	@GetMapping("update")
	public String update(Model model, PetVO petVO) throws Exception {
		petVO = petService.detail(petVO);
		model.addAttribute("petVO", petVO);
		
		return "pet/add";
	}
	
	@PostMapping("update")
	public String update(Model model, @Valid PetVO petVO, BindingResult bindingResult, MultipartFile image) throws Exception {
		if(bindingResult.hasErrors()) {
			return "pet/add";
		}
		
		int result = petService.update(petVO, image);
		String msg = "수정 실패";
		if(result > 0) {
			msg = "수정 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", "./detail?petNo=" + petVO.getPetNo());
		
		return "commons/result";
	}
	
	@PostMapping("delete")
	public String delete(Model model, PetVO petVO) throws Exception {
		int result = petService.delete(petVO);
		
		String msg = "삭제 실패";
		if(result > 0) {
			msg = "삭제 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", "./list");
		
		return "commons/result";
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int fileDelete(Model model, PetFileVO petFileVO) throws Exception {
		return petService.fileDelete(petFileVO);
	}
	
	@GetMapping("adopt")
	public String adopt(Model model, PetVO petVO) throws Exception {
		return "pet/adopt";
	}
	
	
	
	
}
