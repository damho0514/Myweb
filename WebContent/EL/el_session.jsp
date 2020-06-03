
<%@page import="com.myweb.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	UserVO vo = new UserVO();
	vo.setName("홍길자");
	vo.setId("aaa123");
	
	session.setAttribute("uuu", "kkk123");
	session.setAttribute("vo", vo);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="el_session_ok.jsp">el확인</a>
		
</body>
</html>