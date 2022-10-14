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
	 * insert : 공지사항 등록
	 */
	public int insert(MyshopNoticeVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	/**
	 * selectAll : 공지사항 list 전부조회
	 */
	public ArrayList<MyshopNoticeVO> selectAll() {
		List<MyshopNoticeVO> list = sqlSession.selectList(namespace+".select_all");
		return (ArrayList<MyshopNoticeVO>) list;
	}
	/**
	 * totalCount : 공지사항 수
	 */
	public int totalCount() {
		return sqlSession.selectOne(namespace+".total_count");
	}
	
	/**
	 * delete : 공지사항 삭제
	 */
	public int delete(String nid) {
		System.out.println("dao진입");
		return sqlSession.delete(namespace+".delete",nid);
	}

	/**
	 * select : 공지사항 정보 조회
	 */
	public MyshopNoticeVO select(String nid) {
		return sqlSession.selectOne(namespace+".select",nid);
	}
	
	/**
	 * update : 공지사항 정보 수정
	 */
	public int update(MyshopNoticeVO vo) {
		return sqlSession.update(namespace+".update",vo);
	}
	
	
}
