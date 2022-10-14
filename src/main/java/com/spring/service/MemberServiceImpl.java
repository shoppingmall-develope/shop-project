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
	 * ȸ������ ó��
	 */
	public int getJoinResult(MyshopMemberVO vo) {
			
		return 	memberDao.insert(vo);
	}
	
	/** 
	 * ���̵� �ߺ� Ȯ�� ó��(ajax)
	 */
	public int getIdCheck(String id) {
		return memberDao.idCheck(id);
	}
	
	/** 
	 * �α��� ó��
	 */
	public SessionVO getLoginResult(MyshopMemberVO vo) {
		return memberDao.select(vo);
	}
	
	/** 
	 * �������� ó�� ���� �߼�
	 */
	public String sendRandomMessage(String pnumber){
	    Naver_Sens_V2 message = new Naver_Sens_V2();
	    Random rand = new Random();
	    String numStr = "";
	    for (int i = 0; i < 6; i++) {
	        String ran = Integer.toString(rand.nextInt(10));
	        numStr += ran;
	    }
	    System.out.println("ȸ������ ���� ���� => " + numStr);

	    message.send_msg(pnumber, numStr);

	    return numStr;
	}
}
