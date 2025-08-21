package com.goodee.mini.donation.kakaopay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KakaoPayController {

    @RequestMapping("/kakaoPaySuccess")
    public String success() {
        return "donation/success"; // 추후 성공 페이지 연결
    }

    @RequestMapping("/kakaoPayCancel")
    public String cancel() {
        return "결제 취소";
    }

    @RequestMapping("/kakaoPayFail")
    public String fail() {
        return "donation/fail";
    }
}
