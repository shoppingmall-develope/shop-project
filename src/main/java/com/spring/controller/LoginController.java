package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.vo.MyshopMemberVO;
import com.myshop.vo.SessionVO;
import com.spring.service.MemberServiceImpl;

@Controller
public class LoginController {
	@Autowired
	private MemberServiceImpl memberService;	
	
	//�α��� ������ 
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView login(String auth) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("auth", auth);     //interceptor���� �Ѿ�� auth �ޱ�
		mv.setViewName("login");
		return mv;
	}
		
	//�α��� ó��
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	public ModelAndView loginCheck(MyshopMemberVO vo, HttpSession session) {
	ModelAndView mv = new ModelAndView();
			
		SessionVO svo= memberService.getLoginResult(vo);
		
		if(svo != null) {
			if(svo.getLoginresult() == 1){
				//�α��� ���� --> session��ü�� key(sid),value(�α��ΰ���) �߰� �� index �������� �̵�
				session.setAttribute("svo", svo);
				//mv.addObject("login_result","ok");
				mv.setViewName("myshop");
			}
		}else{
			mv.addObject("login_result","fail");
			mv.setViewName("login");
		}
		
		return mv;
	}
	
	
	//��������
	@ResponseBody
	@RequestMapping(value="/sendmess.do", method=RequestMethod.GET)
	public String sendmess(String pnumber) {
		
		String code= memberService.sendRandomMessage(pnumber);
		
		
		return code;
	}
		
}
