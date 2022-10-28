package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopOrderDAO;
import com.myshop.vo.MyshopOrderVO;
import com.myshop.vo.MyshopSearchVO;

public class OrderServiceImpl implements OrderService{
	@Autowired
	private MyshopOrderDAO  orderDao;
	
	public MyshopOrderVO getInfo(String oid) {
		return orderDao.select_info(oid);
	}
	
	public ArrayList<MyshopOrderVO> getList(String id) {
		return orderDao.select(id);
	}
	
	public int updateStatus(int oid) {
		return orderDao.update_status(oid);
	}
	public ArrayList<MyshopOrderVO> getCount(String id){
		return orderDao.select_status_count(id);
	}
	
	public ArrayList<MyshopOrderVO> getSearchList(MyshopSearchVO vo){
		return orderDao.search_select(vo);
	}
	
}
