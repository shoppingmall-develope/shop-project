package com.myshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopNoticeVO;

@Repository
public class MyshopNoticeDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.notice";
	
	/**
	 * insert : �������� ���
	 */
	public int insert(MyshopNoticeVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	/**
	 * selectAll : �������� list ������ȸ
	 */
	public ArrayList<MyshopNoticeVO> selectAll() {
		List<MyshopNoticeVO> list = sqlSession.selectList(namespace+".select_all");
		return (ArrayList<MyshopNoticeVO>) list;
	}
	/**
	 * totalCount : �������� ��
	 */
	public int totalCount() {
		return sqlSession.selectOne(namespace+".total_count");
	}
	
	/**
	 * delete : �������� ����
	 */
	public int delete(String nid) {
		System.out.println("dao����");
		return sqlSession.delete(namespace+".delete",nid);
	}

	/**
	 * select : �������� ���� ��ȸ
	 */
	public MyshopNoticeVO select(String nid) {
		return sqlSession.selectOne(namespace+".select",nid);
	}
	
	/**
	 * update : �������� ���� ����
	 */
	public int update(MyshopNoticeVO vo) {
		return sqlSession.update(namespace+".update",vo);
	}
	
	
}
