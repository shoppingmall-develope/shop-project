package com.spring.service;

import com.myshop.vo.MyshopMemberVO;
import com.myshop.vo.SessionVO;

public interface MemberService {
	int getJoinResult(MyshopMemberVO vo);
	int getIdCheck(String id);
	SessionVO getLoginResult(MyshopMemberVO vo);
}
