package com.spring.service;

import java.util.ArrayList;
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
	 * ���̵� ã��
	 */
	@Override
	public MyshopMemberVO findId(MyshopMemberVO vo) {
		return memberDao.findId(vo);
	}
	
	/**
	 * ��й�ȣ ã��
	 */
	@Override
	public MyshopMemberVO findPass(MyshopMemberVO vo) {
		return memberDao.findPass(vo);
	}
	
	
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
	
	/** 
	 * ������ ȸ�� ����Ʈ
	 */
	public ArrayList<MyshopMemberVO> getList(){
		return memberDao.selectAll();
	}
	
	/** 
	 * ������ ��ü ȸ�� ����Ʈ ��
	 */
	public int getTotalCount() {
		return memberDao.totalCount();
	}
	
	/** 
	 * �ֱ� �湮�� �ֽ�ȭ
	 */
	public void updateVisit(String id) {
		memberDao.updateVisit(id);
	}
	/** 
	 * �˻�����Ʈ ����
	 */
	public ArrayList<MyshopMemberVO> getSearchList(String searchtext, String sorttype){
		return memberDao.selectSearch(searchtext,sorttype);
	}
	
	/** 
	 * ȸ�� Ż��
	 */
	public int getDelete(String id) {
		return memberDao.delete(id);
	}
	
	/** 
	 * ȸ�� ���º���
	 */
	public MyshopMemberVO getContent(String id) {
		return memberDao.select(id);
	}
	
	public int getUpdate(MyshopMemberVO vo) {
		return memberDao.update(vo);
	}
}
