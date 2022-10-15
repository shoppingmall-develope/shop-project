package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopNoticeDAO;
import com.myshop.vo.MyshopNoticeVO;
import com.myshop.vo.MyshopSearchVO;

public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private MyshopNoticeDAO noticeDao;
	
	//�������� ����
	public int getWriteResult(MyshopNoticeVO vo) {
		return noticeDao.insert(vo);
	}
	
	//admin - ��ü �������� ����Ʈ
	public ArrayList<MyshopNoticeVO> getList(){
		return noticeDao.selectAll();
	}
	
	//admin - ���� �˻� ����Ʈ
	public ArrayList<MyshopNoticeVO>getAdminSearchList(MyshopSearchVO vo){
		return noticeDao.search_select(vo);
	}
	
	//��ü �������� ����
	public int getTotalCount() {
		return noticeDao.totalCount();
	}
	
	//�������� ����
	public int getDelete(String nid) {
		return noticeDao.delete(nid);
	}
	
	//�������� ���� ��������
	public MyshopNoticeVO getContent(String nid) {
		return noticeDao.select(nid);
	}
	
	//�������� ���� ��������
	public int getUpdate(MyshopNoticeVO vo) {
		return noticeDao.update(vo);
	}
	
	//����� - ��ü �������� ����Ʈ
	public ArrayList<MyshopNoticeVO> getList(int startCount, int endCount){
		return noticeDao.user_selectAll(startCount,endCount);
	}
	
	//����� - �˻� �������� ����Ʈ
	public ArrayList<MyshopNoticeVO> getSearchList(String text, String searchtype, int startCount, int endCount){
		return noticeDao.search_select(text, searchtype, startCount,endCount);
	}
	
	
}
