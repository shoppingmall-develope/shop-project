package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.dao.MyshopProductDAO;
import com.myshop.vo.MyshopCategoryVO;
import com.myshop.vo.MyshopProductVO;
import com.spring.controller.ProductController;

@Service
public class ProductServiceImpl implements ProductService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private MyshopProductDAO productDao;
	//����¡ ó��
	@Override
	public int getTotalCount() {
		return productDao.totalCount();
	}
	//��ǰ ����Ʈ
	@Override
	public ArrayList<MyshopProductVO> getList(int startCount, int endCount) {
		ArrayList<MyshopProductVO> list = productDao.select(startCount, endCount);
		System.out.println(list);
		return list;
	}
	
	//��ǰ����
	@Override
	public int updateProduct(MyshopProductVO vo) {
		return productDao.update(vo);
	}
	//��ǰ���� ������������
	@Override
	public MyshopProductVO getContent(String pid) {
		return productDao.select(pid);
	}

	
	//��ǰ�˻�
	@Override
	public List<MyshopProductVO> getProductList( String keyword, int startCount, int endCount) {
		System.out.println("search_service");
		ArrayList<MyshopProductVO> list = productDao.getProductList( keyword, startCount, endCount);
		return list;
	}
	//��ǰ����
	@Override
	public int deleteProduct(String pid) {
		return productDao.delectProduct(pid);
	}	
	
	//ī�װ� ������ /�з�
	@Override
	public ArrayList<MyshopProductVO> category_select( int category_parent,int category_id ,int startCount, int endCount) {
//		System.out.println("---" + category_id);
		ArrayList<MyshopProductVO> list = productDao.category_select(category_parent,category_id , startCount, endCount);
		
		return list;
	}
	//��ǰ�߰�
	@Override
	public int getWriteResult(MyshopProductVO vo) {
		return productDao.insert(vo);
	}
	
	//��ǰ�󼼺��� 
	@Override
	public MyshopProductVO getDetail(int pid) {
		return productDao.select(pid);
	}
	//ī�װ� ����Ʈ
	@Override
	public List<MyshopCategoryVO> cateList(String dept_level) {
		return productDao.cateList(dept_level);
	}
	//ī�װ� �޴��� ����Ʈ
	@Override
	public List<MyshopCategoryVO> cateListAjax(String cateCode) {
		
		return productDao.cateListAjax(cateCode);
	}
	
	//��Ӵٿ� ī�װ� ����Ʈ
	@Override
	public List<MyshopCategoryVO> getWcateCode() {
		return productDao.getWcateCode();
	}
	@Override
	public List<MyshopCategoryVO> getMcateCode() {
		return productDao.getMcateCode();
	}
	@Override
	public List<MyshopCategoryVO> getKcateCode() {
		return productDao.getKcateCode();
	}
	@Override
	public List<MyshopCategoryVO> getLcateCode() {
		return productDao.getLcateCode();
	}
	
	
	
	
	
	

	
}
