package com.spring.service;

import java.util.ArrayList;

import com.myshop.vo.MyshopNoticeVO;

public interface NoticeService {
	int getWriteResult(MyshopNoticeVO vo);
	ArrayList<MyshopNoticeVO> getList();
	int getTotalCount();
	int getDelete(String nid);
	MyshopNoticeVO getContent(String nid);
	int getUpdate(MyshopNoticeVO vo);
}
