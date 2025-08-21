package com.goodee.mini.donation.kakaopay;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoPayService {
	
	@Value("${kakao.admin-key}")
    private String adminKey;

	@PostConstruct
	public void init() {
	    System.out.println("Authorization header: KakaoAK " + adminKey);
	}
	
	public KakaoPayReadyResponse kakaoPayReady(int amount) {
	    String requestUrl = "https://open-api.kakaopay.com/online/v1/payment/ready";

	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "SECRET_KEY " + adminKey);

	    Map<String, Object> params = new HashMap<>();
	    params.put("cid", "TC0ONETIME");
	    params.put("partner_order_id", "1001");
	    params.put("partner_user_id", "user1");
	    params.put("item_name", "테스트상품");
	    params.put("quantity", "1");
	    params.put("total_amount", String.valueOf(amount));
	    params.put("tax_free_amount", 0);
	    params.put("approval_url", "http://localhost:80/kakaoPaySuccess");
	    params.put("cancel_url", "http://localhost:80/kakaoPayCancel");
	    params.put("fail_url", "http://localhost:80/kakaoPayFail");

	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(params, headers);

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<KakaoPayReadyResponse> response = restTemplate.postForEntity(
	            URI.create(requestUrl),
	            entity,
	            KakaoPayReadyResponse.class
	    );

	    return response.getBody();
	}
	    
}
