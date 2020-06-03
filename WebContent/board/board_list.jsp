<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">

    <title>Welcome to MyWorld</title>
	
	<!-- 외부 CSS파일을  임포트 -->
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	 <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>






	<style>
	.btn {
		border: 0; /*border스타일 해제*/
		border-radius: 0; /*윤곽 0*/
		padding: 5px 10px; /*버튼 패딩을 페이지네이션과 맞춘다*/
		margin: 20px 0px;
	}
	</style>

</head>
<body>
	
	<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		<h3>My Web게시판</h3>
		
		<!-- onchange는 태그가 변경됨 감지해서 실행하는 이벤트 -->
		<select onchange="change(this)">
			<option value="10" ${pageVO.amount == 10 ? 'selected' : '' }>10개씩보기</option>
			<option value="20" ${pageVO.amount == 20 ? 'selected' : '' }>20개씩보기</option>
			<option value="50" ${pageVO.amount == 50 ? 'selected' : '' }>50개씩보기</option>
			<option value="100"${pageVO.amount == 100 ? 'selected' : '' }>100개씩보기</option>
		</select>
		
		
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
			
			<c:forEach var="vo" items="${list }">
			<tbody>
				<tr>
					<td>${vo.bno }</td>
					<td>${vo.writer }</td>
					<td>
						<a href="content.board?bno=${vo.bno }">${vo.title }</a>
					</td>
					<td>
					<fmt:formatDate value="${vo.regdate }" pattern="yyyy년 MM월 dd일 hh:mm:ss"/>	
					 </td>
					<td>${vo.hit }</td>
				</tr>
			</tbody>
			</c:forEach>
			
			
			
			
			<tbody>
				<tr>
					<td colspan="5" align="center">
	               			
	               			
	               			<ul class="pagination pagination-sm">
                        		
                        		
                        		<!-- 3.이전버튼 처리 -->
                        		<c:if test="${pageVO.prev }">
                        		<li><a href="list.board?pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
                        		</c:if>
                        		<!-- 1.페이지 처리 -->
                        		<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }"  >
                        		<li  class="${num == pageVO.pageNum ? 'active' : '' }">
                        			<a href="list.board?pageNum=${num }&amount=${pageVO.amount}">${num }</a>
                        		</li>
                        		</c:forEach>
                        		
                        		<!-- 2.다음버튼 처리 -->
                        		<c:if test="${pageVO.next }">
                        		<li><a href="list.board?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
                    			</c:if>
                    		</ul>
                    		
                    		
                    		
						<input type="button" value="글 작성" class="btn btn-default pull-right" onclick="location.href='write.board' ">
					
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>
	
	<%@ include file="../include/footer.jsp" %>
	
	
	<script>
		function change(a) {
			//console.log(a);
			//console.log(a.value)
			location.href = "list.board?pageNum=1&amount=" + a.value;
		}
	
	</script>
	
	
</body>
</html>







