package com.goodee.mini.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.goodee.mini.member.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckAdminInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().toUpperCase().equals("POST")) {
			return;
		}
		
		MemberVO memberVO = (MemberVO)request.getSession(false).getAttribute("member");
		if(memberVO == null) {
			modelAndView.addObject("msg", "권한이 필요합니다");
			modelAndView.addObject("url", "./list");
			modelAndView.setViewName("commons/result");
		}
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
