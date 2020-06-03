<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="../MultiuploadServlet" method="post" enctype="multipart/form-data">
		파일1:<input type="file" name="file01"><br>
		파일2:<input type="file" name="file02"><br>
		파일3:<input type = "file" name="file03"><br>
		
		<input type="submit" value="업로드">
	</form>
</body>
</html>