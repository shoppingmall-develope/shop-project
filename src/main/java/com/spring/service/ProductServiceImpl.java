package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.dao.Myshop_productDAO;
import com.myshop.vo.MyshopCategoryVO;
import com.myshop.vo.MyshopProductVO;
import com.spring.controller.ProductController;

@Service
public class ProductServiceImpl implements ProductService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private Myshop_productDAO productDao;
	//페이징 처리
	@Override
	public int getTotalCount() {
		return productDao.totalCount();
	}
	//상품 리스트
	@Override
	public ArrayList<MyshopProductVO> getList(int startCount, int endCount) {
		ArrayList<MyshopProductVO> list = productDao.select(startCount, endCount);
		System.out.println(list);
		return list;
	}

	//상품추가
	@Override
	public int getWriteResult(MyshopProductVO vo) {
		return productDao.insert(vo);
	}
	
	//상품상세보기 
	@Override
	public MyshopProductVO getDetail(int pid) {
		return productDao.select(pid);
	}
	//카테고리 리스트
	@Override
	public List<MyshopCategoryVO> cateList(String dept_level) {
		return productDao.cateList(dept_level);
	}
	@Override
	public List<MyshopCategoryVO> cateListAjax(String cateCode) {
		
		return productDao.cateListAjax(cateCode);
	}
	
	//드롭다운 카테고리 리스트
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
