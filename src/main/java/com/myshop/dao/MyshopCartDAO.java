package com.myshop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.vo.MyshopCartVO;
import com.myshop.vo.MyshopProductVO;

@Repository
public class MyshopCartDAO {

   @Autowired
   private SqlSessionTemplate sqlSession;
   
   
   /**
    * insert : ��ٱ��� �߰�
    */
   public int insert(MyshopCartVO vo) {
      //sqlSession ��ü�� �޼ҵ带 ȣ���Ͽ� �������� ������
      System.out.println("..vo");
      return sqlSession.insert("mapper.cart.add", vo);
   }


   public ArrayList<MyshopCartVO> select(String id) {
   
      
      List<MyshopCartVO> list = sqlSession.selectList("mapper.cart.list", id);
      
      return (ArrayList<MyshopCartVO>)list;
   }
}