package com.myshop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopReviewVO;

@Repository
public class MyshopReviewDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.review";
	
	//리뷰글 쓰기 처리
	public int insert(MyshopReviewVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	//관리자 - 리뷰 리스트
	public ArrayList<MyshopReviewVO> adminselectAll() {
		List<MyshopReviewVO> list = sqlSession.selectList(namespace+".admin_selectAll");
		return (ArrayList<MyshopReviewVO>) list;
	}
	
	//리뷰 개수
	public int totalCount() {
		return sqlSession.selectOne(namespace+".totalcount");
	}
	
	//상세보기
	public MyshopReviewVO select(String rid) {
		return sqlSession.selectOne(namespace+".content",rid);
	}
	
	//
	public int delete(String rid) {
		return sqlSession.delete(namespace+".delete",rid);
	}
	
	//사용자 -리뷰 리스트
	public ArrayList<MyshopReviewVO> selectAll(int startCount, int endCount) {
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MyshopReviewVO> list = sqlSession.selectList(namespace+".selectAll",param);
		return (ArrayList<MyshopReviewVO>) list;
	}
	
}
