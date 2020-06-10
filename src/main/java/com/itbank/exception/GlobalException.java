package com.itbank.exception;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CannotGetJdbcConnectionException.class)
	public ModelAndView DbConnectFailed() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("msg", "네트워크에 문제가 있습니다.");
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView NullPoint() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("msg", "잘못된 접근 입니다.");
		return mv;
	} 
}
