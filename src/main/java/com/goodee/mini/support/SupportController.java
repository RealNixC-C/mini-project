package com.goodee.mini.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.goodee.mini.member.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/support/*")
@RequiredArgsConstructor
public class SupportController {
	
	@Autowired
	private SupportService supportService;
	
	@GetMapping("info")
	public String info() throws Exception {
		
		return "support/info";
	}
	
    //Toss 결제 성공 콜백
	@GetMapping("/toss/success")
    public String success(@RequestParam String paymentKey, @RequestParam String orderId, @RequestParam Long amount, Model model, HttpSession session) throws Exception {
        // Toss API Confirm
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("test_sk_KNbdOvk5rkeq0M0Jk4lE3n07xlzm"); // secretKey

        Map<String, Object> body = new HashMap<>();
        body.put("paymentKey", paymentKey);
        body.put("orderId", orderId);
        body.put("amount", amount);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://api.tosspayments.com/v1/payments/confirm",
                entity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
        	MemberVO memberVO = (MemberVO)session.getAttribute("member");
        	Long memNo = memberVO.getMemNo();
        	
            // 결제 성공 → DB 저장
        	supportService.saveSupport(memNo, amount, orderId, paymentKey, "CARD", "PAID");

        	model.addAttribute("msg", "후원이 성공적으로 완료되었습니다! 🐾");
            model.addAttribute("url", "/support/info");
            return "commons/result";
        } else {
        	model.addAttribute("msg", "후원 결제에 실패했습니다. 다시 시도해주세요.");
            model.addAttribute("url", "/support/info");
            return "commons/result";
        }
    }
	 
	 	
	    //Toss 결제 실패 콜백
	    @GetMapping("/toss/fail")
	    public String fail(@RequestParam Map<String, String> params, Model model) {
	    	model.addAttribute("msg", "후원 결제가 실패했습니다. 사유: " + params.get("message"));
	        model.addAttribute("url", "/support/info");
	        return "commons/result";
	    }
}
