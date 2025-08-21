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
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoPayService {
	
//	@Value("${kakao.admin-key}")
//    private String adminKey;

    public KakaoPayReadyResponse kakaoPayReady(int amount) {
        // 요청 URL
        String requestUrl = "https://kapi.kakao.com/v1/payment/ready";

        // 요청 헤더
        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "KakaoAK " + adminKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 요청 파라미터
        Map<String, String> params = new HashMap<>();
        params.put("cid", "TC0ONETIME"); // 테스트 CID
        params.put("partner_order_id", "1001");
        params.put("partner_user_id", "user1");
        params.put("item_name", "테스트상품");
        params.put("quantity", "1");
        params.put("total_amount", String.valueOf(amount));
        params.put("tax_free_amount", "0");
        params.put("approval_url", "http://localhost:8080/kakaoPaySuccess"); // 성공 시 redirect URL
        params.put("cancel_url", "http://localhost:8080/kakaoPayCancel");
        params.put("fail_url", "http://localhost:8080/kakaoPayFail");

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<KakaoPayReadyResponse> response = restTemplate.postForEntity(
                URI.create(requestUrl),
                entity,
                KakaoPayReadyResponse.class
        );

        return response.getBody();
    }
	
}
