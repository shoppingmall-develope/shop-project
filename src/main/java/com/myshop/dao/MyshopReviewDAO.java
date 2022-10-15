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
	
	//����� ���� ó��
	public int insert(MyshopReviewVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	//������ - ���� ����Ʈ
	public ArrayList<MyshopReviewVO> adminselectAll() {
		List<MyshopReviewVO> list = sqlSession.selectList(namespace+".admin_selectAll");
		return (ArrayList<MyshopReviewVO>) list;
	}
	
	//���� ����
	public int totalCount() {
		return sqlSession.selectOne(namespace+".totalcount");
	}
	
	//�󼼺���
	public MyshopReviewVO select(String rid) {
		return sqlSession.selectOne(namespace+".content",rid);
	}
	
	//
	public int delete(String rid) {
		return sqlSession.delete(namespace+".delete",rid);
	}
	
	//����� -���� ����Ʈ
	public ArrayList<MyshopReviewVO> selectAll(int startCount, int endCount) {
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MyshopReviewVO> list = sqlSession.selectList(namespace+".selectAll",param);
		return (ArrayList<MyshopReviewVO>) list;
	}
	
}
