package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopNoticeDAO;
import com.myshop.vo.MyshopNoticeVO;

public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private MyshopNoticeDAO noticeDao;
	
	//공지사항 쓰기
	public int getWriteResult(MyshopNoticeVO vo) {
		return noticeDao.insert(vo);
	}
	
	//전체 공지사항 리스트
	public ArrayList<MyshopNoticeVO> getList(){
		return noticeDao.selectAll();
	}
	
	//전체 공지사항 개수
	public int getTotalCount() {
		return noticeDao.totalCount();
	}
	
	//공지사항 삭제
	public int getDelete(String nid) {
		return noticeDao.delete(nid);
	}
	
	//공지사항 정보 가져오기
	public MyshopNoticeVO getContent(String nid) {
		return noticeDao.select(nid);
	}
	
	//공지사항 정보 가져오기
	public int getUpdate(MyshopNoticeVO vo) {
		return noticeDao.update(vo);
	}
}
