package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.SalesVO;
import com.itbank.service.SalesService;

@Controller
public class SalesController {
	
	@Autowired
	private SalesService ss;
	
	@RequestMapping(value="/sales", method = RequestMethod.GET)
	public ModelAndView sales () {		
		return ss.selectAll();
		
	}
	
	@RequestMapping(value="/sales/insert", method = RequestMethod.GET)
	public ModelAndView salesUpdat(HttpServletRequest req) {
		
		return ss.selectAll(req);
	}
	
	@RequestMapping(value="/sales/insert", method = RequestMethod.POST)
	public ModelAndView salesInsert(SalesVO vo) {
		
		return ss.insert(vo);
	}
	
	@RequestMapping(value="/sales", method = RequestMethod.POST)
	public ModelAndView salesCancel (String cancel) {
		
		System.out.println(cancel);
		
		return ss.cancel(cancel);
	}
	
}
