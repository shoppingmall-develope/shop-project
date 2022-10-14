package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myshop.vo.SessionVO;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
									throws Exception {
		
		//������ üũ�ϴ� ���� ����
		//1. request ��ü�� ���� session ������ ��������
		HttpSession session = request.getSession();
		
		//2. �α��� ���� �� session�� �α��� ����Ű(sid) ��� Ŭ���̾�Ʈ���� ����
		SessionVO svo = (SessionVO)session.getAttribute("svo");  //�α����� ����:�ڽ��� ID, �α������� ���� �����: null
		
		if(svo == null) {			
			//�α������� ���� �����: null
			response.sendRedirect("http://localhost:9000/myshop/login.do?auth=fail");
			
			return false;
		}else {
			//svo�� null�� �ƴϰ�, admin �� ��쿡�� ����
			if(!svo.getId().equals("admin")) {
				response.sendRedirect("http://localhost:9000/myshop/login.do?auth=fail");
				return false;
			}
		}		
		
			return true;
	}

}
