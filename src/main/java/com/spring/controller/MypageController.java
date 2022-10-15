package com.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.vo.MyshopOrderVO;
import com.spring.service.OrderServiceImpl;

@Controller
public class MypageController {
	@Autowired
	private OrderServiceImpl orderService;
	
		//마이페이지 - 주문관리
		@RequestMapping(value="/mypage_order.do", method=RequestMethod.GET)
		public ModelAndView mypage_order() {
			ModelAndView mv = new ModelAndView();
			String id = "admin";
			
			ArrayList<MyshopOrderVO> list = orderService.getList(id);			
			
			mv.addObject("list",list);
			mv.setViewName("/mypage_order");
			
			return mv;
		}
		
		
}
