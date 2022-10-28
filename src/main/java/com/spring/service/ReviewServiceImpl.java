package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopReviewDAO;
import com.myshop.vo.MyshopOrderVO;
import com.myshop.vo.MyshopReviewVO;
import com.myshop.vo.MyshopSearchVO;

public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private MyshopReviewDAO  reviewDao;
	
	public int getWriteResult(MyshopReviewVO vo) {
		return reviewDao.insert(vo);
	}
	
	public ArrayList<MyshopReviewVO> getList() {
		return reviewDao.adminselectAll();
	}
	
	public int getTotalCount() {
		return reviewDao.totalCount();
	}
	
	public int getDelete(String rid) {
		return reviewDao.delete(rid);
	}
	//������ ���� �󼼺���
	public MyshopReviewVO getContent(String rid) {
		return reviewDao.select(rid);
	}
	public ArrayList<MyshopReviewVO> getList(int startCount, int endCount) {
		return reviewDao.selectAll(startCount,endCount);
	}
	
	//����� ���� �󼼺���
	public MyshopReviewVO getReviewContent(String rid) {
		return reviewDao.userSelect(rid);
	}
	
	//���� ���� ó��
	public int getUpdateReview(MyshopReviewVO vo) {
		return reviewDao.update(vo);
	}
	
	public int delete(String rid) {
		return reviewDao.delete(rid);
	}
	
	public ArrayList<MyshopReviewVO> getAdminSearchList(MyshopSearchVO vo){
		return reviewDao.searchreview(vo);
	}
}
