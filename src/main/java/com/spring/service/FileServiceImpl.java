package com.spring.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.myshop.vo.MyshopNoticeVO;
import com.myshop.vo.MyshopProductVO;
import com.myshop.vo.MyshopReviewVO;

public class FileServiceImpl {
	
	public void fileSave(MyshopProductVO vo, HttpServletRequest request) throws Exception {
		//�����̸�
	if(!vo.getFile1().getOriginalFilename().equals("")) {
		String path = request.getSession().getServletContext().getRealPath("/");
		path += "\\resources\\upload\\";
		//������ġ, �����̸��� ��ģ ��ü 
		File file = new File(path+vo.getPsfile());
		//��������
		vo.getFile1().transferTo(file);
		}
	}
	
	/**
	 * �������� : ���� upload ������ ����
	 */
	public void fileSave(MyshopNoticeVO vo, HttpServletRequest request) throws Exception {
		//2. upload ������ nsfile ������ ���� ���� ���ε� ó��
		if(!vo.getFile1().getOriginalFilename().equals("")) {
			String path = request.getSession().getServletContext().getRealPath("/");
			path += "\\resources\\upload\\";
			
			File file = new File(path+vo.getNsfile());
			vo.getFile1().transferTo(file);
		}
	}
	
	/**
	 * �������� : ���� üũ �� nfile, nsfile ����
	 */
	public MyshopNoticeVO fileCheck(MyshopNoticeVO vo) {
		//1. vo��ü�� ����üũ �� nfile, nsfile�� ����Ǵ� �̸� ����
		if(vo.getFile1().getOriginalFilename().equals("")) {
			vo.setNfile("");
			vo.setNsfile("");
		}else {
			UUID uuid = UUID.randomUUID();
			vo.setNfile(vo.getFile1().getOriginalFilename());
			vo.setNsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
		}
		
		return  vo;
	}//fileCheck
	
	
	/**
	 * �������� : ���ο� ������ �ִ� ��� update�� ����üũ
	 */
	public MyshopNoticeVO update_fileCheck(MyshopNoticeVO vo) {
		if(vo.getFile1() != null) {	//���ο� ���ϰ�ü�� �ִ��� ����üũ �ϴ� ��쿡�� null�� ���
			if(!vo.getFile1().getOriginalFilename().equals("")) { //���ο� ���ϼ��� O
				
				UUID uuid = UUID.randomUUID();
				
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid+"_"+vo.getFile1().getOriginalFilename());
			}
		}
		return vo;
	}
	
	/**
	 * �Խ��� : ������ �ִ� ��� update�� ��������
	 */
	public void update_filesave(MyshopNoticeVO vo, HttpServletRequest request, String old_filename) 
														throws Exception {
		//���ο� ������ upload ������ ����
		if(!vo.getFile1().getOriginalFilename().equals("")) { //���ο� ���ϼ��� O
			String path = request.getSession().getServletContext().getRealPath("/");
			path += "\\resources\\upload\\";
			System.out.println(path);
			
			File file = new File(path+vo.getNsfile());
			vo.getFile1().transferTo(file);
		
			//���������� �ִ� ��쿡�� ���� ����
			File ofile = new File(path+old_filename);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	
	/**
	 * ���� : ���� üũ �� rfile, rsfile ����
	 */
	public MyshopReviewVO fileCheck(MyshopReviewVO vo) {
		//1. vo��ü�� ����üũ �� nfile, nsfile�� ����Ǵ� �̸� ����
		if(vo.getFile1().getOriginalFilename().equals("")) {
			vo.setRfile("");
			vo.setRsfile("");
		}else {
			UUID uuid = UUID.randomUUID();
			vo.setRfile(vo.getFile1().getOriginalFilename());
			vo.setRsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
		}
		
		return  vo;
	}//fileCheck
	
	
	/**
	 * ���� : ���� upload ������ ����
	 */
	public void fileSave(MyshopReviewVO vo, HttpServletRequest request) throws Exception {
		//2. upload ������ nsfile ������ ���� ���� ���ε� ó��
		if(!vo.getFile1().getOriginalFilename().equals("")) {
			String path = request.getSession().getServletContext().getRealPath("/");
			path += "\\resources\\upload\\";
			
			File file = new File(path+vo.getRsfile());
			vo.getFile1().transferTo(file);
		}
	}
	
	/**
	 * ��ǰ : ���ο� ������ �ִ� ��� update�� ����üũ
	 */
	public MyshopProductVO update_fileCheck(MyshopProductVO vo) {
		if(vo.getFile1() != null) {	//���ο� ���ϰ�ü�� �ִ��� ����üũ �ϴ� ��쿡�� null�� ���
			if(!vo.getFile1().getOriginalFilename().equals("")) { //���ο� ���ϼ��� O
				
				UUID uuid = UUID.randomUUID();
				
				vo.setPfile(vo.getFile1().getOriginalFilename());
				vo.setPsfile(uuid+"_"+vo.getFile1().getOriginalFilename());
			}
		}
		return vo;
	}
	
	
	/**
	 * ��ǰ : ������ �ִ� ��� update�� ��������
	 */
	public void update_filesave(MyshopProductVO vo, HttpServletRequest request, String old_filename) 
														throws Exception {
		//���ο� ������ upload ������ ����
		if(!vo.getFile1().getOriginalFilename().equals("")) { //���ο� ���ϼ��� O
			String path = request.getSession().getServletContext().getRealPath("/");
			path += "\\resources\\upload\\";
			System.out.println(path);
			
			File file = new File(path+vo.getPsfile());
			vo.getFile1().transferTo(file);
		
			//���������� �ִ� ��쿡�� ���� ����
			File ofile = new File(path+old_filename);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
}
