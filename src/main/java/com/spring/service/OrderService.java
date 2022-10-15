package com.spring.service;

import java.util.ArrayList;

import com.myshop.vo.MyshopOrderVO;

public interface OrderService {
	MyshopOrderVO getInfo(String oid);
	ArrayList<MyshopOrderVO> getList(String id);
}
