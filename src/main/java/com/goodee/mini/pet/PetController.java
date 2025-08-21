package com.goodee.mini.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pet/*")
public class PetController {

	@Autowired
	private PetService petService;
	
	@GetMapping("list")
	public String list(PetVO petVO, Model model) throws Exception {
		List<PetVO> list = petService.list();
		
		return "pet/list";
	}
	
}
