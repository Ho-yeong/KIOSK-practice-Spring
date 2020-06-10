package com.itbank.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;

	public ModelAndView login(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("home");
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");

		System.out.println(userid);
		System.out.println(userpw);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("userid", userid);
		map.put("userpw", userpw);
		
		HttpSession session = req.getSession(false);
		
		session.setAttribute("login", dao.login(map));
		
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	
}
