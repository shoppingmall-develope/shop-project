package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class NoticeController {
	//ȸ������
	@RequestMapping(value="/review_write.do", method=RequestMethod.GET)
	public String review_write() {
		return "/review_write";
	}

}
