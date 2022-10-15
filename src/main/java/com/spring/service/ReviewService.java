package com.spring.service;

import java.util.ArrayList;

import com.myshop.vo.MyshopReviewVO;

public interface ReviewService {
	int getWriteResult(MyshopReviewVO vo);
	ArrayList<MyshopReviewVO> getList();
	int getTotalCount();
	int getDelete(String rid);
	MyshopReviewVO getContent(String rid);
	ArrayList<MyshopReviewVO> getList(int startCount, int endCount);
}
