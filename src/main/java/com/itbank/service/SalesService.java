package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.dao.ProductDAO;
import com.itbank.dao.ProductVO;
import com.itbank.dao.SalesDAO;
import com.itbank.dao.SalesVO;
import com.itbank.dao.UserDAO;
import com.itbank.dao.UserVO;

@Service
public class SalesService {
	
	@Autowired
	private SalesDAO dao;
	
	@Autowired
	private ProductDAO pdao;
	
	@Autowired
	private UserDAO udao;
	
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView("sales");
		
		List<SalesVO> list = dao.selectAll();
		
		List<ProductVO> plist = pdao.selectAll();
		
		int total = 0;
		int cancel = 0;
		for (SalesVO v : list) {
			if(v.getResult().equals("1")) {
				total += v.getPrice();
			}
			if(v.getResult().equals("0")) {
				cancel += v.getPrice();
			}
			if(v.getResult().equals("1")) {
				v.setResult("정상처리");
			} else if (v.getResult().equals("0")) {
				v.setResult("취소됨");
			} else {
				v.setResult("결제오류");
			}
		}
		
		mv.addObject("cancel", cancel);
		mv.addObject("total", total);
		mv.addObject("list", list);
		mv.addObject("plist", plist);
		
		return mv;
	}

	public ModelAndView selectAll(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("salesInsert");
		
		List<SalesVO> list = dao.selectAll();
		
		ProductVO plist = pdao.selectOne(req.getParameter("name"));
		
		mv.addObject("list", list);
		mv.addObject("plist", plist);
		
		return mv;
	}
	
	@Transactional
	public ModelAndView insert(SalesVO vo) {
		ModelAndView mv = new ModelAndView("redirect:/sales");
		
		
		// 상품갯수 감소
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", vo.getName());
		map.put("amount", String.valueOf(vo.getAmount()));
		
		pdao.update(map);	
		
		// 회원 쿠폰 증가
		int uResult = 0;
		UserVO uvo = new UserVO();
		List<UserVO> list = udao.selectAll();
		for (UserVO v : list) {
			if(v.getName().equals(vo.getBuyer())) {
				uvo = v;
				HashMap<String, String> map2 = new HashMap<String, String>();
				
				map2.put("name", uvo.getName());
				map2.put("number", String.valueOf(vo.getAmount()));
				
				udao.update(map2);
			}
		}
		
		// 구매자 회원 확인
		boolean flag = false;
		
		for(UserVO v : list) {
			if(v.getName().equals(vo.getBuyer())) {
				flag = true;
			}
		}
		if (!flag) {
			vo.setBuyer("");
		}
		
		
		int result = dao.insert(vo);
		if (result != 1) {
			mv.addObject("msg", "매출 등록 실패");
			mv.setViewName("error");
		}
		return mv;
	}
	
	@Transactional
	public ModelAndView cancel(String vo) {
		ModelAndView mv = new ModelAndView("redirect:/sales");
		
		// 모든 리스트소환 받아온 날짜랑 비교
		List<SalesVO> list = dao.selectAll();
		
		SalesVO nn = new SalesVO();
		
		for (SalesVO v : list) {
			if(vo.equals(String.valueOf(v.getTime()))) {
				nn = v;
			}
		}
		// 이미 취소된 내역이 있는지 확인
		
		for(SalesVO v : list) {
			if(v.getResult().equals("0")) {
				if(v.getName().equals(nn.getName()) && v.getPrice() == nn.getPrice() && v.getAmount() == nn.getAmount()) {
					
					mv.addObject("msg", "이미 취소된 내역 입니다.");
					mv.setViewName("error");
					return mv;
					
				}
			}
		}
		
				


		// 상품갯수 다시 증가
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", nn.getName());
		map.put("amount", String.valueOf(nn.getAmount()));
		
		pdao.updateCancel(map);
		
		// 회원 쿠폰 감소
		if(nn.getBuyer() != null) {
			HashMap<String, String> map2 = new HashMap<String, String>();
			
			map2.put("name", nn.getBuyer());
			map2.put("number", String.valueOf(nn.getAmount()));
			
			udao.updateCancel(map2);
		}
		
		// 취소명세서 인설트
		nn.setResult("0");
		
		if(nn.getBuyer() == null) {
			nn.setBuyer("비회원");
		}
		
		int result = dao.insert(nn);
		if (result != 1) {
			mv.addObject("msg", "매출 취소 실패");
			mv.setViewName("error");
		}
		
		return mv;
	}

}
