package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.ProductVO;
import com.itbank.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public ModelAndView product () {
		
		return ps.selectAll();
	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public ModelAndView productDelete (HttpServletRequest req) {
		return ps.delete(req);
	}
	
	@RequestMapping(value="/product/update", method = RequestMethod.GET)
	public ModelAndView productUpdate (@RequestParam("name") String name) {
		
		return ps.selectOne(name);
	}
	
	@RequestMapping(value="/product/update", method = RequestMethod.POST)
	public ModelAndView productUpdate (ProductVO vo) {
		System.out.println(vo.getName());
		System.out.println(vo.getPrice());
		System.out.println(vo.getAmount());
		
		return ps.update(vo);
	}
	
	@RequestMapping(value="/product/insert", method = RequestMethod.GET)
	public ModelAndView productInsert () {
		ModelAndView mv = new ModelAndView("productInsert");
		
		return mv;
	}
	
	@RequestMapping(value="/product/insert", method = RequestMethod.POST)
	public ModelAndView productInsert (ProductVO vo) {
		return ps.insert(vo);
	}
}
