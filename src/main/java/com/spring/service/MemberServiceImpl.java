package com.spring.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopMemberDAO;
import com.myshop.dao.Naver_Sens_V2;
import com.myshop.vo.MyshopMemberVO;
import com.myshop.vo.SessionVO;


public class MemberServiceImpl implements MemberService{
	@Autowired
	private MyshopMemberDAO memberDao;
	
	/** 
	 * 회원가입 처리
	 */
	public int getJoinResult(MyshopMemberVO vo) {
			
		return 	memberDao.insert(vo);
	}
	
	/** 
	 * 아이디 중복 확인 처리(ajax)
	 */
	public int getIdCheck(String id) {
		return memberDao.idCheck(id);
	}
	
	/** 
	 * 로그인 처리
	 */
	public SessionVO getLoginResult(MyshopMemberVO vo) {
		return memberDao.select(vo);
	}
	
	/** 
	 * 본인인증 처리 난수 발송
	 */
	public String sendRandomMessage(String pnumber){
	    Naver_Sens_V2 message = new Naver_Sens_V2();
	    Random rand = new Random();
	    String numStr = "";
	    for (int i = 0; i < 6; i++) {
	        String ran = Integer.toString(rand.nextInt(10));
	        numStr += ran;
	    }
	    System.out.println("회원가입 문자 인증 => " + numStr);

	    message.send_msg(pnumber, numStr);

	    return numStr;
	}
}
