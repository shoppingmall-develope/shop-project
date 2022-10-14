package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopNoticeDAO;
import com.myshop.vo.MyshopNoticeVO;

public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private MyshopNoticeDAO noticeDao;
	
	//�������� ����
	public int getWriteResult(MyshopNoticeVO vo) {
		return noticeDao.insert(vo);
	}
	
	//��ü �������� ����Ʈ
	public ArrayList<MyshopNoticeVO> getList(){
		return noticeDao.selectAll();
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
}
