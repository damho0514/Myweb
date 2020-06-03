<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 파일업로드에서는 enctype타입을 multipart/form-data 형으로 반드시 설정 -->
	
	<form action="../UploadServlet" method="post" enctype="multipart/form-data">
	
		글쓴이:<input type="text" name="name"><br>
		제목:<input type="text" name="title"><br>
		파일선택:<input type="file" name="fileName"><br>
		
		<input type="submit" value="전송">
		
	</form>
	
</body>
</html>