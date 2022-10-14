package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.myshop.vo.MyshopCategoryVO;
import com.myshop.vo.MyshopProductVO;

public interface ProductService {
	/**
	 * 페이징처리
	 */
	int getTotalCount();
	/** 
	 * 관리자 상품리스트
	 */
	ArrayList<MyshopProductVO> getList(int startCount, int endCount);
	
	
	/** 관리자 상품추가 **/
	int getWriteResult(MyshopProductVO vo);
	
	/** 상품 상세보기 **/
	MyshopProductVO getDetail(int pid);
	
	//카테고리 리스트
	List<MyshopCategoryVO> cateList(String dept_level);
	List<MyshopCategoryVO> cateListAjax(String cateCode);
		
	//여성 카테고리 리스트 드롭다운
	List<MyshopCategoryVO> getWcateCode();
	//남성 카테고리 리스트 드롭다운
	List<MyshopCategoryVO> getMcateCode();
	//키즈 카테고리 리스트 드롭다운
	List<MyshopCategoryVO> getKcateCode();
	//라이프 카테고리 리스트 드롭다운
	List<MyshopCategoryVO> getLcateCode();
}
