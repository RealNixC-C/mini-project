package com.goodee.mini.donation.kakaopay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    @PostMapping("/pay")
    public String kakaoPay(@RequestParam("amount") int amount) {
        KakaoPayReadyResponse response = kakaoPayService.kakaoPayReady(amount);
        return "redirect:" + response.getNext_redirect_pc_url();
    }

    @RequestMapping("/success")
    public String success() {
        return "결제 성공"; // 혹은 성공 페이지 뷰 이름
    }

    @RequestMapping("/cancel")
    public String cancel() {
        return "결제 취소"; // 혹은 취소 페이지 뷰 이름
    }

    @RequestMapping("/fail")
    public String fail() {
        return "결제 실패"; // 혹은 실패 페이지 뷰 이름
    }
}
