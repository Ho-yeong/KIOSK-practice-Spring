package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) {
		
		
		return ms.login(req);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("redirect:/");
		
		HttpSession session = req.getSession(false);
		
		session.invalidate();
		
		return mv;
	}
	
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView LoginFailed() {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("msg", "로그인 오류");
			// site를 추가하지 않으면 history.go(-1);
			// mv.addObject("site", "/site");
			return mv;
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		
		return "error";
	}
	
}
