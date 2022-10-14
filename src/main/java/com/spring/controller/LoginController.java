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
	
	//로그인 페이지 
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView login(String auth) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("auth", auth);     //interceptor에서 넘어온 auth 받기
		mv.setViewName("login");
		return mv;
	}
		
	//로그인 처리
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	public ModelAndView loginCheck(MyshopMemberVO vo, HttpSession session) {
	ModelAndView mv = new ModelAndView();
			
		SessionVO svo= memberService.getLoginResult(vo);
		
		if(svo != null) {
			if(svo.getLoginresult() == 1){
				//로그인 성공 --> session객체에 key(sid),value(로그인계정) 추가 후 index 페이지로 이동
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
	
	
	//본인인증
	@ResponseBody
	@RequestMapping(value="/sendmess.do", method=RequestMethod.GET)
	public String sendmess(String pnumber) {
		
		String code= memberService.sendRandomMessage(pnumber);
		
		
		return code;
	}
		
}
