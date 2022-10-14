package com.myshop.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopMemberVO;
import com.myshop.vo.SessionVO;
@Repository
public class MyshopMemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	/**
	 * insert : ȸ������ 
	 */
	public int insert(MyshopMemberVO vo) {
		//sqlSession ��ü�� �޼ҵ带 ȣ���Ͽ� �������� ������
		
		return sqlSession.insert("mapper.member.join", vo);
	}
	
	/**
	 * idCheck : ���̵� �ߺ�üũ
	 */
	public int idCheck(String id) {
		return sqlSession.selectOne("mapper.member.idcheck",id);
	}
	
	public SessionVO select(MyshopMemberVO vo) {
		return sqlSession.selectOne("mapper.member.login", vo);
	}
}
