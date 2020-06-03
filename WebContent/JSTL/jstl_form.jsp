<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>JSTL if문확인</h3>
	
	<form action="jstl_if.jsp">
		이름:<input type="text" name="name" ><br>
		나이:<input type="text" name="age" ><br>
		<input type="submit" value="확인"><br>
	</form>
	
	
	<hr>
	
	<h3>JSTL choose문확인</h3>
	<form action="jstl_choose.jsp">
		이름:<input type="text" name="name" ><br>
		나이:<input type="text" name="age" ><br>
		<input type="submit" value="확인"><br>
	</form>
	
	<hr>
	
	<h3>JSTL 중첩choose문확인</h3>
	<form action="jstl_choose1.jsp">
		점수:<input type="text" name="point">
	</form>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>