package com.myshop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopCategoryVO;
import com.myshop.vo.MyshopProductVO;

@Repository
public class Myshop_productDAO {
	//sqlSession
	@Autowired 
	private SqlSessionTemplate sqlSession;
	

	//totalCount 
	public int totalCount() {
		return sqlSession.selectOne("totalcount");
	}
	
	public ArrayList<MyshopProductVO> select(int startCount,int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MyshopProductVO> list = sqlSession.selectList("mapper.product.list", param);
		
		return (ArrayList<MyshopProductVO>)list;
	}
	// ������ ��ǰ���  ó��
	public int insert(MyshopProductVO vo) {
		return sqlSession.insert("mapper.product.insert", vo);
	}
	
	//��ǰ�󼼸�� ��ȸ
	public MyshopProductVO select(int pid) {
		return sqlSession.selectOne("mapper.product.productDetail",pid);
	}
	
	//������ ��ǰ���� ī�װ�����Ʈ
	public List<MyshopCategoryVO> cateList(String dept_level) {
		return sqlSession.selectList("mapper.product.cateList", dept_level);
	}
	
	
	//������ ��ǰ���� ī�װ�����Ʈ
	public List<MyshopCategoryVO> cateListAjax(String cateCode) {
		return sqlSession.selectList("mapper.product.cateListAjax", Integer.parseInt(cateCode));
	}
	
	public List<MyshopCategoryVO> getWcateCode() {
		return sqlSession.selectList("mapper.product.getWcateCode");
	}
	
	public List<MyshopCategoryVO> getMcateCode() {
		return sqlSession.selectList("mapper.product.getMcateCode");
	}
	public List<MyshopCategoryVO> getKcateCode() {
		return sqlSession.selectList("mapper.product.getKcateCode");
	}
	public List<MyshopCategoryVO> getLcateCode() {
		return sqlSession.selectList("mapper.product.getLcateCode");
	}
	
	
}
