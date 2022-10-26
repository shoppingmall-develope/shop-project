package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.myshop.vo.MyshopCategoryVO;
import com.myshop.vo.MyshopNoticeVO;
import com.myshop.vo.MyshopProductVO;

public interface ProductService {
	/**
	 * ����¡ó��
	 */
	int getTotalCount();
	/** 
	 * ������ ��ǰ����Ʈ
	 */
	ArrayList<MyshopProductVO> getList(int startCount, int endCount);
	/**
	 * ������ ��ǰ ���� 
	 */
	int updateProduct(MyshopProductVO vo);
	/**
	 * ������ ��ǰ���� ������������
	 */
	MyshopProductVO getContent(String pid);	
	/**
	 * ������ ��ǰ��� ����Ʈ ����
	 */
	int deleteProduct(String pid);
	/** ī�װ��� ��ǰ��� **/
	ArrayList<MyshopProductVO> category_select( int category_parent,int category_id , int startCount, int endCount);
	/** ��ǰ�˻� **/
	List<MyshopProductVO> getProductList(String keyword, int startCount, int endCount);
	/** ������ ��ǰ�߰� **/
	int getWriteResult(MyshopProductVO vo);
	/** ��ǰ �󼼺��� **/
	MyshopProductVO getDetail(int pid);
	//ī�װ� ����Ʈ
	List<MyshopCategoryVO> cateList(String dept_level);
	List<MyshopCategoryVO> cateListAjax(String cateCode);
	//���� ī�װ� ����Ʈ ��Ӵٿ�
	List<MyshopCategoryVO> getWcateCode();
	//���� ī�װ� ����Ʈ ��Ӵٿ�
	List<MyshopCategoryVO> getMcateCode();
	//Ű�� ī�װ� ����Ʈ ��Ӵٿ�
	List<MyshopCategoryVO> getKcateCode();
	//������ ī�װ� ����Ʈ ��Ӵٿ�
	List<MyshopCategoryVO> getLcateCode();
}
