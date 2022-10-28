package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.myshop.vo.MyshopMemberVO;
import com.myshop.vo.MyshopNoticeVO;
import com.myshop.vo.MyshopReviewVO;
import com.myshop.vo.MyshopSearchVO;
import com.spring.service.FileServiceImpl;
import com.spring.service.MemberServiceImpl;
import com.spring.service.NoticeServiceImpl;
import com.spring.service.ReviewServiceImpl;
@Controller
public class AdminController {
		@Autowired
		private FileServiceImpl  fileService;
		
		@Autowired
		private NoticeServiceImpl  noticeService;
		
		@Autowired
		private ReviewServiceImpl  reviewService;
		
		@Autowired
		private MemberServiceImpl  memberService;
		
		//������ - admin_header
		@RequestMapping(value="/admin_header.do", method=RequestMethod.GET)
		public String admin_header() {
			return "/admin/admin_header";
		}
		//������ - ȸ������
		@RequestMapping(value="/admin_customercare.do", method=RequestMethod.GET)
		public ModelAndView admin_customercare() {
			ModelAndView mv= new ModelAndView();
			
			ArrayList<MyshopMemberVO> list = memberService.getList();
			int totalcount = memberService.getTotalCount();
			
			mv.addObject("list", list);
			mv.addObject("totalcount", totalcount);
			mv.setViewName("/admin/admin_customercare");
			return mv;
		}	
		
		//������- ȸ�� ���İ˻� ó��
		@ResponseBody
		@RequestMapping(value="/admin_member_search.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
		public String admin_member_search(String searchtext,String sorttype) {
			ArrayList<MyshopMemberVO> search_list=memberService.getSearchList(searchtext, sorttype);
			
			String result="";
			
			if(search_list.size() != 0) {
				
				JsonObject jobject = new JsonObject(); 
				JsonArray jarray = new JsonArray();  //ArrayList
				Gson gson = new Gson();
				
				for(MyshopMemberVO mvo: search_list) {
					JsonObject jo = new JsonObject();
					jo.addProperty("name", mvo.getName());
					jo.addProperty("id", mvo.getId());
					jo.addProperty("email", mvo.getEmail());
					jo.addProperty("grade", mvo.getGrade());
					jo.addProperty("acc", mvo.getAcc());
					jo.addProperty("visit", mvo.getVisit());
					
					
					jarray.add(jo);
				}
				jobject.add("list", jarray);
				jobject.addProperty("count", search_list.size());
				
				result = gson.toJson(jobject);
			}else {
				result="0";
			}
			return result;
		}
		//������ - ��� ����Ʈ���� ���� ����(���߻���) - ajax
		@ResponseBody
		@RequestMapping(value="/admin_member_list_delete.do", method=RequestMethod.POST)
		public int admin_member_list_delete(@RequestParam(value="clist[]") ArrayList<String> clist) {
			int result = 0;
			/* System.out.println("11111"); */
			for(String id : clist) {
	            System.out.println(id);
				result = memberService.getDelete(id);
	        }
		
			return result;
		}
		//������ - ��� ���� ����
		@ResponseBody
		@RequestMapping(value="/admin_member_delete.do", method=RequestMethod.GET)
		public int admin_member_list_delete(String id) {
			int result = 0;
			/* System.out.println("11111"); */
			System.out.println(id);
			result = memberService.getDelete(id);
			System.out.println(result);
			return result;
		}
		
		//������ - ȸ�� �󼼺���
		@RequestMapping(value="/admin_member_content.do", method=RequestMethod.GET)
		public ModelAndView admin_member_content(String id) {
			ModelAndView mv = new ModelAndView();
			
			MyshopMemberVO vo = memberService.getContent(id);
			
			mv.addObject("vo", vo);
			mv.setViewName("/admin/admin_member_content");
			return mv;
		}
		//������ - ȸ�� �󼼺��� - ȸ�� ����
		@RequestMapping(value="/admin_member_update.do", method=RequestMethod.GET)
		public ModelAndView admin_member_update(String id) {
			ModelAndView mv = new ModelAndView();
			
			MyshopMemberVO vo = memberService.getContent(id);
			
			mv.addObject("vo", vo);
			mv.setViewName("/admin/admin_member_update");
			return mv;
		}
		
		@RequestMapping(value="/admin_member_update_check.do", method=RequestMethod.POST)
		public ModelAndView admin_member_update_check(MyshopMemberVO vo) {
			ModelAndView mv = new ModelAndView();
			
			int result = memberService.getUpdate(vo);
			if(result == 1) {
				
				mv.addObject("update_result", "ok");	
				mv.setViewName("redirect:/admin_member_content.do?id="+vo.getId());
			}else {
				mv.setViewName("error_page");
			}
						
			return mv;
		}
		
		//������ - admin-home
		@RequestMapping(value="/admin.do", method=RequestMethod.GET)
		public String admin() {
			return "/admin/admin";
		}
		
		//������ - ���� ����Ʈ
		@RequestMapping(value="/admin_review_list.do", method=RequestMethod.GET)
		public ModelAndView admin_review_list() {
			ModelAndView mv = new ModelAndView();
			
			int totalcount = reviewService.getTotalCount();
			ArrayList<MyshopReviewVO> list= reviewService.getList();
			mv.addObject("list", list);
			mv.addObject("totalcount",totalcount);
			mv.setViewName("/admin/admin_review_list");
			return mv;
		}
		
		//������ - ���� �󼼺���
		@ResponseBody
		@RequestMapping(value="/admin_review_content.do", method=RequestMethod.GET)
		public MyshopReviewVO admin_review_content(String rid) {
			MyshopReviewVO vo = reviewService.getContent(rid);
			return vo;
		}
		
		
		//������ - ���� ����Ʈ���� ���� ����(���߻���) - ajax
		@ResponseBody
		@RequestMapping(value="/admin_review_list_delete.do", method=RequestMethod.POST)
		public int admin_review_list_delete(@RequestParam(value="clist[]") ArrayList<String> clist) {
			int result = 0;
			System.out.println("11111");
			for(String rid : clist) {
		        System.out.println(rid);
		        result = reviewService.getDelete(rid);
		    }
			
			return result;
		}
		
		//������ - ���� ����Ʈ �˻�- ajax
		@ResponseBody
		@RequestMapping(value="/admin_review_search.do", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
		public String admin_review_search(@RequestBody MyshopSearchVO vo) {
			System.out.println(vo.getSearchscore());
			ArrayList<MyshopReviewVO> list = reviewService.getAdminSearchList(vo);
			
			JsonObject jobject = new JsonObject(); 
			JsonArray jarray = new JsonArray();  
			Gson gson = new Gson();
			
			for(MyshopReviewVO rvo: list) {
				JsonObject jo = new JsonObject();
				jo.addProperty("rid", rvo.getRid());
				jo.addProperty("pname", rvo.getPname());
				jo.addProperty("category_id", rvo.getCategory_id());
				jo.addProperty("rcontent", rvo.getRcontent());
				jo.addProperty("rwriter", rvo.getRwriter());
				jo.addProperty("score", rvo.getScore());
				jo.addProperty("rsfile", rvo.getRsfile());
				jo.addProperty("recom", rvo.getRecom());
				jo.addProperty("rdate", rvo.getRdate());	
				
				jarray.add(jo);
			}
			jobject.add("list", jarray);
			jobject.addProperty("count", list.size());
			
			System.out.println(gson.toJson(jobject));

			return gson.toJson(jobject);

		}	
		
		
		//������ - �������� ����Ʈ
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
		
		//������ - �������� ���ǰ˻� -ajax
		@ResponseBody
		@RequestMapping(value="/admin_notice_search.do", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
		public String admin_notice_search(@RequestBody MyshopSearchVO vo) {
			System.out.println("��Ʈ�ѷ�");
			/* System.out.println(vo.getText()); */
			ArrayList<MyshopNoticeVO> list = noticeService.getAdminSearchList(vo);
			
			JsonObject jobject = new JsonObject(); //CgvNoticeVO
			JsonArray jarray = new JsonArray();  //ArrayList
			Gson gson = new Gson();
			
			for(MyshopNoticeVO nvo: list) {
				JsonObject jo = new JsonObject();
				jo.addProperty("rno", nvo.getRno());
				jo.addProperty("nid", nvo.getNid());
				jo.addProperty("ntitle", nvo.getNtitle());
				jo.addProperty("ncrucial", nvo.getNcrucial());
				jo.addProperty("nfile", nvo.getNfile());
				jo.addProperty("nsdate", nvo.getNsdate());
				jo.addProperty("nedate", nvo.getNedate());
				jo.addProperty("ncode", nvo.getNcode());
				
				jarray.add(jo);
			}
			jobject.add("list", jarray);
			jobject.addProperty("count", list.size());
			
			System.out.println(gson.toJson(jobject));

			return gson.toJson(jobject);
		}
				
		//������ - �������� �۾���
		@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
		public String admin_notice_write() {
			return "/admin/admin_notice_write";
		}
		//������ - �������� �۾��� ó��
		@RequestMapping(value="/admin_notice_write_check.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_write_check(MyshopNoticeVO vo, HttpServletRequest request)
			throws Exception{
			ModelAndView mv = new ModelAndView();
			
			vo = fileService.fileCheck(vo);
			System.out.println(vo.getNsfile());
			int result = noticeService.getWriteResult(vo);
			
			if(result == 1){			
				fileService.fileSave(vo, request);
				mv.setViewName("redirect:/admin_notice_list.do");
			}else{

				mv.setViewName("error_page");
			}		
			
			return mv;

		}
		
		//������ - �������� ����Ʈ���� ���� ����(���߻���) - ajax
		@ResponseBody
		@RequestMapping(value="/admin_notice_list_delete.do", method=RequestMethod.POST)
		public int admin_notice_list_delete(@RequestParam(value="clist[]") ArrayList<String> clist) {
			int result = 0;
			System.out.println("11111");
			for(String nid : clist) {
	            System.out.println(nid);
	            result = noticeService.getDelete(nid);
	        }
		
			return result;
		}
		
		//������ - �������� ����������
		@RequestMapping(value="/admin_notice_update_check.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_update_check(MyshopNoticeVO vo, HttpServletRequest request) 
													throws Exception{
			ModelAndView mv = new ModelAndView();
			String old_filename = vo.getNsfile();
			
			vo = fileService.update_fileCheck(vo);
			int result = noticeService.getUpdate(vo);
			
			if(result == 1){
				//���ο� ������ upload ������ ������ �� ������ ������ ����
				fileService.update_filesave(vo, request, old_filename);
				mv.setViewName("redirect:/admin_notice_list.do");
				
			}else{

				mv.setViewName("error_page");
			}		
			
			return mv;
		}
		
		//������ - �������� ����ó��
		@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
		public ModelAndView admin_notice_update(String nid) {
			ModelAndView mv = new ModelAndView();
			MyshopNoticeVO vo = noticeService.getContent(nid);
			mv.addObject("vo", vo);
			mv.setViewName("/admin/admin_notice_update");
			return mv;
		}
		
		//������ - q&a ����Ʈ
		@RequestMapping(value="/admin_qna_list.do", method=RequestMethod.GET)
		public String admin_qna_list() {
			return "/admin/admin_qna_list";
		}
		
		
		//������ - ����ڰ���/�޼��� ������
		@RequestMapping(value="/admin_message.do", method=RequestMethod.GET)
		public String admin_message() {
			return "/admin/admin_message";
		}
		//������ - �ֹ�����/�ֹ����� ������
		@RequestMapping(value="/admin_order_management.do", method=RequestMethod.GET)
		public String admin_order_management() {
			return "/admin/admin_order_management";
		}
		//������ - �ֹ�����/�ֹ���� ������
		@RequestMapping(value="/admin_order_cancel_management.do", method=RequestMethod.GET)
		public String admin_order_cancel_management() {
			return "/admin/admin_order_cancel_management";
		}
			
		
		
		
}
