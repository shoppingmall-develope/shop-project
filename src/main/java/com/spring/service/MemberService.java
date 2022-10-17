package com.spring.service;

import java.util.ArrayList;

import com.myshop.vo.MyshopMemberVO;
import com.myshop.vo.SessionVO;

public interface MemberService {
	int getJoinResult(MyshopMemberVO vo);
	int getIdCheck(String id);
	SessionVO getLoginResult(MyshopMemberVO vo);
	ArrayList<MyshopMemberVO> getList();
	int getTotalCount();
	void updateVisit(String id);
	ArrayList<MyshopMemberVO> getSortList(String sorttype);
}
