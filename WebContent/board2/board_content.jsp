<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%"></td>
			
			<td width="20%">조회수</td>
			<td width="30%"></td>
		</tr>
		<tr>
			<td width="20%">작성자</td>
			<td width="30%"></td>
			
			<td width="20%">작성일</td>
			<td width="30%"></td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3" width="30%"></td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" width="30%" height="120px"></td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록">&nbsp;&nbsp;
				<input type="button" value="수정">&nbsp;&nbsp;
				<input type="button" value="삭제">&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
	
	

	

</div>



</body>
</html>