package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.vo.MyshopNoticeVO;
import com.spring.service.FileServiceImpl;
import com.spring.service.NoticeServiceImpl;
@Controller
public class AdminController {
		@Autowired
		private FileServiceImpl  fileService;
		
		@Autowired
		private NoticeServiceImpl  noticeService;
		
		//관리자 - admin_header
		@RequestMapping(value="/admin_header.do", method=RequestMethod.GET)
		public String admin_header() {
			return "/admin/admin_header";
		}
		//관리자 - admin-home
		@RequestMapping(value="/admin_customercare.do", method=RequestMethod.GET)
		public String admin_customercare() {
			return "/admin/admin_customercare";
		}
		//관리자 - admin-home
		@RequestMapping(value="/admin.do", method=RequestMethod.GET)
		public String admin() {
			return "/admin/admin";
		}
		
		//관리자 - 리뷰 리스트
		@RequestMapping(value="/admin_ReviewList.do", method=RequestMethod.GET)
		public String admin_ReviewList() {
			return "/admin/admin_ReviewList";
		}
		//관리자 - 공지사항 리스트
		@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
		public ModelAndView admin_notice_list() {
			ModelAndView mv = new ModelAndView();
			ArrayList<MyshopNoticeVO> list = noticeService.getList();
			int totalcount = noticeService.getTotalCount();
			
			mv.addObject("totalcount",totalcount);
			mv.addObject("list",list);
			mv.setViewName("/admin/admin_notice_list");
			return mv;
		}
		//관리자 - 공지사항 글쓰기
		@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
		public String admin_notice_write() {
			return "/admin/admin_notice_write";
		}
		//관리자 - 공지사항 글쓰기 처리
		@RequestMapping(value="/admin_notice_write_check.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_write_check(MyshopNoticeVO vo, HttpServletRequest request)
			throws Exception{
			ModelAndView mv = new ModelAndView();
			System.out.println(vo.getNtitle());
			System.out.println(vo.getNcontent());
			System.out.println(vo.getNcrucial());
			System.out.println(vo.getNsdate());
			System.out.println(vo.getNedate());
			
			vo = fileService.fileCheck(vo);
			int result = noticeService.getWriteResult(vo);
			
			if(result == 1){			
				fileService.fileSave(vo, request);
				mv.setViewName("redirect:/admin_notice_list.do");
			}else{

				mv.setViewName("error_page");
			}		
			
			return mv;

		}
		//관리자 - 공지사항 리스트에서 선택 삭제(다중삭제) - ajax
		@ResponseBody
		@RequestMapping(value="/admin_notice_list_delete.do", method=RequestMethod.POST)
		public int admin_notice_list_delete(@RequestParam(value="clist[]") ArrayList<String> clist) {
			int result = 0;
			System.out.println("11111");
			for(String nid : clist) {
	            System.out.println(nid);
	            result = noticeService.getDelete(nid);
	        }
		
//			try {
//				int cnt = Integer.parseInt((String) commandMap.get("CNT"));
//				String delete_notice = (String) commandMap.get("delete_list");
//				String[] delete_list = delete_notice.split(",");
//				for (int i = 0; i < cnt; i++) {
//					String nid = (String) delete_list[i];
//					result = noticeService.getDelete(nid);
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			return result;
		}
		
		//관리자 - 공지사항 수정페이지
		@RequestMapping(value="/admin_notice_update_check.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_update_check(MyshopNoticeVO vo, HttpServletRequest request) 
													throws Exception{
			ModelAndView mv = new ModelAndView();
			String old_filename = vo.getNsfile();
			
			vo = fileService.update_fileCheck(vo);
			int result = noticeService.getUpdate(vo);
			
			if(result == 1){
				//새로운 파일을 upload 폴더에 저장한 후 기존의 파일은 삭제
				fileService.update_filesave(vo, request, old_filename);
				mv.setViewName("redirect:/admin_notice_list.do");
				
			}else{

				mv.setViewName("error_page");
			}		
			
			return mv;
		}
		
		//관리자 - 공지사항 수정처리
		@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
		public ModelAndView admin_notice_update(String nid) {
			ModelAndView mv = new ModelAndView();
			MyshopNoticeVO vo = noticeService.getContent(nid);
			mv.addObject("vo", vo);
			mv.setViewName("/admin/admin_notice_update");
			return mv;
		}
		
		//관리자 - q&a 리스트
		@RequestMapping(value="/admin_qna_list.do", method=RequestMethod.GET)
		public String admin_qna_list() {
			return "/admin/admin_qna_list";
		}
		
		//관리자 - q&a 리스트
		@RequestMapping(value="/admin_review_list.do", method=RequestMethod.GET)
		public String admin_review_list() {
			return "/admin/admin_review_list";
		}

		
		
		
		//관리자 - 사용자관리/메세지 페이지
		@RequestMapping(value="/admin_message.do", method=RequestMethod.GET)
		public String admin_message() {
			return "/admin/admin_message";
		}
		//관리자 - 주문관리/주문내역 페이지
		@RequestMapping(value="/admin_order_management.do", method=RequestMethod.GET)
		public String admin_order_management() {
			return "/admin/admin_order_management";
		}
		//관리자 - 주문관리/주문취소 페이지
		@RequestMapping(value="/admin_order_cancel_management.do", method=RequestMethod.GET)
		public String admin_order_cancel_management() {
			return "/admin/admin_order_cancel_management";
		}
		
		
}
