<%@page import="com.myweb.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//리퀘스트에 저장
	UserVO vo = new UserVO();
	vo.setId("abc123");
	vo.setName("이순신");
	
	//리퀘스트에 저장
	request.setAttribute("vo", vo);
	
	
	RequestDispatcher dp = request.getRequestDispatcher("el_request_ok.jsp");
	dp.forward(request, response);
	
%>
