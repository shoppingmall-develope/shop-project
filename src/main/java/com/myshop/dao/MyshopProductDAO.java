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
public class MyshopProductDAO {
	//sqlSession
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	
	//��ǰ����
		public int update(MyshopProductVO vo) {
			return sqlSession.update("mapper.product.update",vo);
		}
		
		//��ǰ���� ������������

		/**
		 * select : ��ǰ ���� ��ȸ
		 */
		public MyshopProductVO select(String pid) {
			return sqlSession.selectOne("mapper.product.select",pid);
		}
	
	

	//totalCount 
	public int totalCount() {
		return sqlSession.selectOne("mapper.product.totalcount");
	}
	
	public ArrayList<MyshopProductVO> select(int startCount,int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MyshopProductVO> list = sqlSession.selectList("mapper.product.list", param);
		
		return (ArrayList<MyshopProductVO>)list;
	}
	//��ǰ��� ī�װ��� ����Ʈ
		public ArrayList<MyshopProductVO> category_select(int category_parent, int category_id ,int startCount,int endCount) {
			Map<String, String> param = new HashMap<String, String>();
			
			param.put("category_parent", String.valueOf(category_parent));
			param.put("category_id", String.valueOf(category_id));
			param.put("start", String.valueOf(startCount));
			param.put("end", String.valueOf(endCount));
			
			List<MyshopProductVO> list = sqlSession.selectList("mapper.product.category_select", param);
			
			return (ArrayList<MyshopProductVO>)list;
		}
		
		//��ǰ �˻�
		public ArrayList<MyshopProductVO> getProductList( String keyword, int startCount, int endCount) {
			Map<String, String> param = new HashMap<String, String>();
			System.out.println(keyword);
			param.put("keyword", keyword);
			param.put("start", String.valueOf(startCount));
			param.put("end", String.valueOf(endCount));
			
			List<MyshopProductVO> list = sqlSession.selectList("mapper.product.getProductList", param);
			
			return (ArrayList<MyshopProductVO>) list;
		}
		
		//������ ��ǰ��� ��������Ʈ ����
		public int delectProduct(String pid) {
			System.out.println("���� ---> dao");
			return sqlSession.delete("mapper.product.deleteProduct", pid);
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
