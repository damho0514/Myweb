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
	
	<c:choose>
		<c:when test="${param.name eq '홍길동' }">
			홍길동 입니다.
		</c:when>
		<c:when test="${param.age >= 20 }">
			20세 이상입니다.
		</c:when>
		<c:otherwise>
			홍길동도 아니고, 20세 이하입니다
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>