package com.myshop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 *  selectSearch : �˻� ����Ʈ
	 */
	public ArrayList<MyshopMemberVO> selectSearch(String searchtext, String sorttype){
		System.out.println("searchtext"+searchtext); 
		System.out.println("sorttype"+sorttype); 
		Map<String,String> param = new HashMap<String,String>();
		param.put("searchtext",searchtext);
		param.put("sorttype",sorttype);
		List<MyshopMemberVO> search_list =sqlSession.selectList("mapper.member.select_search", param);
		return (ArrayList<MyshopMemberVO>)search_list;
	}
	
	/**
	 *  delete : ȸ��Ż��
	 */
	public int delete(String id) {
		System.out.println(id);
		return sqlSession.delete("mapper.member.delete",id);
	}
	
	
	/** 
	 * select : ȸ���󼼺���
	 */
	public MyshopMemberVO select(String id) {
		return sqlSession.selectOne("mapper.member.select",id);
	}
	
	public int update(MyshopMemberVO vo) {
		return sqlSession.update("mapper.member.admin_update",vo);
	}
}
