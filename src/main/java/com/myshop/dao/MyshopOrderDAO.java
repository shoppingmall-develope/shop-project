package com.myshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopOrderVO;

@Repository
public class MyshopOrderDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.order";
	
	/**
	 * select_info : (test) 리뷰작성에 필요한 정보
	 */
	public MyshopOrderVO select_info(String oid) {
		return sqlSession.selectOne(namespace+".info",oid);
	}
	/**
	 * select: 사용자 주문리스트
	 */
	public ArrayList<MyshopOrderVO> select(String id) {
		List<MyshopOrderVO> list = sqlSession.selectList(namespace+".select",id);
		return (ArrayList<MyshopOrderVO>)list;
	}

}
