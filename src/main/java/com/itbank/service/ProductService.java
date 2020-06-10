package com.itbank.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.ProductDAO;
import com.itbank.dao.ProductVO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView("product");
		
		List<ProductVO> list = dao.selectAll();
		
		mv.addObject("list", list);
		
		return mv;
	}

	public ModelAndView insert(ProductVO vo) {
		ModelAndView mv = new ModelAndView("redirect:/product");
		
		vo.setPrice(vo.getPrice().replace(",", ""));
		
		int result = dao.insert(vo);
		if (result != 1) {
			mv.addObject("msg", "상품 등록 실패");
			mv.setViewName("error");
		}
		
		return mv;
	}

	public ModelAndView delete(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("redirect:/product");
		
		String[] list = req.getParameterValues("name");
		List<String> name = new ArrayList<String>();
		for (int i = 0 ; i < list.length; i++) {
			if (list[i] != null)
				name.add(list[i]);
		}
		
		
		int result = dao.delete(name);
		
		if (result < 0) {
			mv.addObject("msg", "상품 삭제 실패");
			mv.setViewName("error");
		}
		
		return mv;
	}

	public ModelAndView selectOne(String name) {
		ModelAndView mv = new ModelAndView("productUpdate");
		
		mv.addObject("p", dao.selectOne(name));
		
		return mv;
	}

	public ModelAndView update(ProductVO vo) {
		ModelAndView mv = new ModelAndView("redirect:/product");
		
		int result = dao.update(vo);
		
		if (result != 1) {
			mv.addObject("msg", "상품 수정 실패");
			mv.setViewName("error");
		}
		
		return mv;
	}

}
