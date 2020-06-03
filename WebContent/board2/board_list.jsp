<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        .btn {
          
            border: 0; /*border스타일 해제*/
            border-radius: 0; /*윤곽 0*/
            padding: 5px 10px; /*버튼 패딩을 페이지네이션과 맞춘다*/
            margin: 20px 0px;
        }
</head>
<body>
	

	<div class="container">
		<h3>My Web게시판</h3>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="5" align="center">
	               			<ul class="pagination pagination-sm">
                        		<li><a href="#">이전</a></li>
                        		<li  class="active"><a href="#">1</a></li>
                        		<li><a href="#">2</a></li>
                        		<li><a href="#">3</a></li>
                        		<li><a href="#">4</a></li>
                        		<li><a href="#">5</a></li>
                        		<li><a href="#">다음</a></li>
                    			</ul>
					<input type="button" value="글 작성" class="btn btn-default pull-right">
					
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>


</body>
</html>







