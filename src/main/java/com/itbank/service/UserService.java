package com.itbank.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.ProductVO;
import com.itbank.dao.UserDAO;
import com.itbank.dao.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView("user");
		
		List<UserVO> list = dao.selectAll();
		
		mv.addObject("list", list);
		
		return mv;
	}

	public ModelAndView delete(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("redirect:/user");
		
		String[] list = req.getParameterValues("usernum");
		List<String> usernum = new ArrayList<String>();
		for (int i = 0 ; i < list.length; i++) {
			if (list[i] != null)
				usernum.add(list[i]);
		}
		
		
		int result = dao.delete(usernum);
		
		if (result < 0) {
			mv.addObject("msg", "상품 삭제 실패");
			mv.setViewName("error");
		}
		
		return mv;
	}

	public ModelAndView insert(UserVO vo) {
		ModelAndView mv = new ModelAndView("redirect:/user");
		
		int result = dao.insert(vo);
		if (result != 1) {
			mv.addObject("msg", "회원 등록 실패");
			mv.setViewName("error");
		}
		
		return mv;
	}
	
}
