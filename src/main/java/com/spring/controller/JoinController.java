package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.vo.MyshopMemberVO;
import com.spring.service.MemberServiceImpl;

@Controller
public class JoinController {
		@Autowired
		private MemberServiceImpl memberService;
		/**
		 * id_check.do : ���̵� �ߺ�Ȯ��- Ajaxȣ��
		 */
		@ResponseBody
		@RequestMapping(value="/id_check.do", method=RequestMethod.GET)
		public String idcheck(String id) {
			int result = memberService.getIdCheck(id);
			return String.valueOf(result);
		}
		
		/**
		 * join.do : ȸ������ �� 
		 */
		@RequestMapping(value="/join.do", method=RequestMethod.GET)
		public String join() {
			return "/join/join";
		}
		
		
		/**
		 * joinCheck.do : ȸ������ ó��
		 */
		@RequestMapping(value="/joinCheck.do", method=RequestMethod.POST)
		public ModelAndView joinCheck(MyshopMemberVO vo) {
			ModelAndView mv = new ModelAndView();
			System.out.println(vo.getId());
			int result = memberService.getJoinResult(vo);
			
			if(result == 1){
				mv.setViewName("redirect:/login.do");
			}else{
				mv.setViewName("error_page");
			}
			
			return mv;
		}
}
