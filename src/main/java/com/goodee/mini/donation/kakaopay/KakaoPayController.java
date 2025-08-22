package com.goodee.mini.donation.kakaopay;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.mini.donation.DonationService;
import com.goodee.mini.donation.DonationVO;
import com.goodee.mini.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KakaoPayController {

	@Autowired
	private DonationService donationService;
	
	@GetMapping("/kakaoPaySuccess")
	public String kakaoPaySuccess(@RequestParam("pg_token") String pgToken, HttpSession session, Model model) throws Exception {
	    // 1. 로그인된 사용자 정보 가져오기 (memNo를 세션에서 가져왔다고 가정)
	    MemberVO memberVO = (MemberVO) session.getAttribute("member"); // 실제 로그인 방식에 따라 수정
	    Long memNo = memberVO.getMemNo();

	    // 2. 결제 금액 가져오기 (세션 또는 kakaoPayReady 시 저장)
	    Integer amount = (Integer) session.getAttribute("donationAmount");

	    // 3. DB 저장을 위한 DonationVO 생성
	    DonationVO donationVO = new DonationVO();
	    donationVO.setMemNo(memNo);
	    donationVO.setDonateAmount(Long.valueOf(amount));
	    donationVO.setDonateDate(LocalDate.now());

	    // 4. DB 저장 (DonationService 또는 Mapper 호출 필요)
	    int result=donationService.insert(donationVO); // 이 메서드를 만들어야 함
	    donationVO.setDonateNo(donationService.selectRecent(donationVO).getDonateNo());
	    
	    model.addAttribute("donation", donationVO);
	    
	    // 5. 성공 페이지로 이동
	    return "donation/success"; // success.jsp로 이동
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
