package com.goodee.mini.donation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.mini.donation.kakaopay.KakaoPayReadyResponse;
import com.goodee.mini.donation.kakaopay.KakaoPayService;

@Controller
@RequestMapping(value="/donation/*")
public class DonationController {
	
	private final KakaoPayService kakaoPayService;

	public DonationController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }
	
	@GetMapping("info")
	public void info() throws Exception{
	}
	
	@PostMapping("pay")
	public String pay(@RequestParam("amount") int amount) throws Exception {
	    // 카카오페이 결제 준비 API 호출
	    // KakaoPayService 호출해서 결제 준비 후 결제 URL 받아오기
	    
	    // 결제 페이지로 리다이렉트
	    KakaoPayReadyResponse response = kakaoPayService.kakaoPayReady(amount);
	    return "redirect:" + response.getNext_redirect_pc_url();
	}
	
}
