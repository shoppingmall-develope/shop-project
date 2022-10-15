package com.myshop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopNoticeVO;
import com.myshop.vo.MyshopSearchVO;

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
	 * selectAll : admin - �������� list ������ȸ
	 */
	public ArrayList<MyshopNoticeVO> selectAll() {
		List<MyshopNoticeVO> list = sqlSession.selectList(namespace+".select_all");
		return (ArrayList<MyshopNoticeVO>) list;
	}
	/**
	 * selectAll : admin - �������� list ���ǰ˻�
	 */
	public ArrayList<MyshopNoticeVO> search_select(MyshopSearchVO vo){
		Map<String,String> param = new HashMap<String,String>();
		param.put("searchtype",vo.getSearchtype());
		param.put("text",vo.getText());
		param.put("nsdate",vo.getStartdate());
		param.put("nedate", vo.getEnddate());
		param.put("ncode", vo.getNcode());
		param.put("ncrucial", vo.getNcrucial());
		param.put("posttype", vo.getPosttype());
		
//		System.out.println(searchtype);
//		System.out.println(text);
//		System.out.println(nsdate);
//		System.out.println(nedate);
		
		List<MyshopNoticeVO> list = sqlSession.selectList(namespace+".search_select",param);
		System.out.println("list:"+list.size());
		
		for(MyshopNoticeVO nvo : list) {
			System.out.print(nvo.getNid()+"\t");
			System.out.print(nvo.getNtitle()+"\t");
			System.out.print(nvo.getNcrucial()+"\n");
			System.out.println("--------------");
		}
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
	
	/**
	 * selectAll : ����� - �������� list ������ȸ
	 */
	public ArrayList<MyshopNoticeVO> user_selectAll(int startCount, int endCount) {
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MyshopNoticeVO> list = sqlSession.selectList(namespace+".user_select_all",param);
		return (ArrayList<MyshopNoticeVO>) list;
	}
	/**
	 * search_select: ����� - �������� list �˻���ȸ
	 */
	public ArrayList<MyshopNoticeVO>search_select(String text, String searchtype, int startCount, int endCount){
		System.out.println(text);
		System.out.println(searchtype);
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("searchtype",searchtype);
		param.put("text",text);
		param.put("start",String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		
		List<MyshopNoticeVO> list = sqlSession.selectList(namespace+".admin_search_select",param);
		return (ArrayList<MyshopNoticeVO>) list;
	}
}
