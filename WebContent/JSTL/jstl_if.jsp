<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- test에는 조건식이 들어갑니다 --%>
	<c:if test="true">
		<b>무조건실행되는 문장</b><br>
	</c:if>
	
	<%-- 
	<% if(request.getParameter("name").equals("이순신")) { %>
		<b>이름이 이순신 입니다</b><br>	
	<% } %>
	--%>
	
	<c:if test="${param.name == '이순신' }">
		<b>이름이 이순신 입니다</b><br>	
	</c:if>
	
	<c:if test="${param.name eq '홍길동' }">
		<b>이름이 홍길동 입니다</b><br>
	</c:if>
	
	<hr>
	
	<!-- 
	age의 파라미터 값이 20이상이면 "성인입니다" 출력
	20미만이라면 "미성년자입니다" 출력
	 -->
	
	<c:if test="${param.age >= 20 }">
		성인입니다
	</c:if>
	<c:if test="${param.age < 20 }">
		미성년자입니다
	</c:if>
	
	
	
	
	
	
	
	
</body>
</html>