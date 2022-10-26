package com.myshop.dao;

import java.util.ArrayList;
import java.util.List;

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
	 * ���̵� ã��
	 */
	public MyshopMemberVO findId(MyshopMemberVO vo) {
		System.out.print("dao == >  findId()���ó��");
		return sqlSession.selectOne("mapper.member.findId", vo);
	}
	/**
	 * ��й�ȣ ã��
	 */
	public MyshopMemberVO findPass(MyshopMemberVO vo) {
		System.out.print("dao == >  findPass()���ó��");
		return sqlSession.selectOne("mapper.member.findPass", vo);
	}
	
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
	
	/**
	 * select : �α��� ó��
	 */
	public SessionVO select(MyshopMemberVO vo) {
		return sqlSession.selectOne("mapper.member.login", vo);
	}
	
	/**
	 * select : �α��� ó��
	 */
	public ArrayList<MyshopMemberVO> selectAll(){
		List<MyshopMemberVO> list = sqlSession.selectList("mapper.member.select_all");
		return (ArrayList<MyshopMemberVO>)list;
	}
	
	/**
	 * totalCount : ��ü ȸ�� ����Ʈ �� 
	 */
	public int totalCount(){
		return sqlSession.selectOne("mapper.member.total_count");
	}
	
	/**
	 * updateVisit : �湮�� ������Ʈ 
	 */
	public int updateVisit(String id) {
		return sqlSession.update("mapper.member.update_visit",id);
	}
	
	/**
	 * updateVisit : �湮�� ������Ʈ 
	 */
	public ArrayList<MyshopMemberVO> selectSort(String sorttype) {
		System.out.println("sortType"+sorttype); 
		List<MyshopMemberVO> sort_list =sqlSession.selectList("mapper.member.select_sort", sorttype);
		return (ArrayList<MyshopMemberVO>)sort_list;
	}
	
	
}
