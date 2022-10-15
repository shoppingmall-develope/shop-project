package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myshop.dao.MyshopOrderDAO;
import com.myshop.vo.MyshopOrderVO;

public class OrderServiceImpl implements OrderService{
	@Autowired
	private MyshopOrderDAO  orderDao;
	
	public MyshopOrderVO getInfo(String oid) {
		return orderDao.select_info(oid);
	}
	
	public ArrayList<MyshopOrderVO> getList(String id) {
		return orderDao.select(id);
	}
}
