package com.goodee.mini.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {

	@Autowired
	private SupportDao supportDao;
	
	public void saveSupport(Long memNo, Long amount, String orderId, String paymentKey, String method, String status) throws Exception {
        SupportVO supportVO = new SupportVO();
        supportVO.setMemNo(memNo);
        supportVO.setAmount(amount);
        supportVO.setOrderId(orderId);
        supportVO.setPaymentKey(paymentKey);
        supportVO.setPaymentMethod(method);
        supportVO.setStatus(status);
        
        supportDao.save(supportVO);
    }
}
