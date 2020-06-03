<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- choose구문으로 90이상 A, 80이상이면 B 70이상이면 C, 나머지는 F로 표현.
		90이상일 때 choose구문을 더 사용해서 95점 이상이라면 A+학점으로 표현.
	 --%>

	<c:choose>
		<c:when test="${param.point >= 90 }">
			<c:choose>
				<c:when test="${param.point >= 95 }">
					A+
				</c:when>
				<c:otherwise>
					A
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${param.point >= 80 }">
			B
		</c:when>
		<c:when test="${param.point >= 70 }">
			C
		</c:when>
		<c:otherwise>
			F
		</c:otherwise>


	</c:choose>





</body>
</html>