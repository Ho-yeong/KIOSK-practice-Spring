package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.ProductVO;
import com.itbank.dao.UserVO;
import com.itbank.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView user () {
		
		return us.selectAll();
		
	}
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ModelAndView userDelete (HttpServletRequest req) {
		return us.delete(req);
		
	}
	
	@RequestMapping(value="/user/insert", method = RequestMethod.GET)
	public String userInsert () {
		
		return "userInsert";
		
	}
	@RequestMapping(value="/user/insert", method = RequestMethod.POST)
	public ModelAndView productInsert (UserVO vo) {
		return us.insert(vo);
	}
	
}
