package com.spring.service;

import com.myshop.vo.MyshopMemberVO;

public interface DiscountPolicy {
	/**
	 * ������å �������̽�
	 */
	int discount(MyshopMemberVO member, int price);
}
