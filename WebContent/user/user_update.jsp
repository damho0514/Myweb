<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	.div_center {
		margin-bottom: 20px;
		margin-top:20px;
		padding: 30px 15px;

	}
</style>



</head>
<body>
	<jsp:include page="../include/header.jsp"/>

	<div align="center" class="div_center">
	<form action="updateForm.user" method="post" name="regForm">
		
		<h3>회원정보 수정 페이지</h3>
		<hr>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" value="${userVO.id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
					<td>
						<input type="password" name="pw" placeholder="비밀번호는 5자 이상 입력">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="pw_check" placeholder="비밀번호는 5자 이상 입력">
					</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="${userVO.name }">
				</td>
				
			</tr>

			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" value="${userVO.email }" placeholder="ex) abc@def.com">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" value="${userVO.address }" placeholder="ex) OO시 OO구">
				</td>
			</tr>
		</table>
		<br>
		
		<input type="button" value="수정" class="btn btn-default" onclick="check()">&nbsp;&nbsp;
		<input type="button" value="취소" class="btn btn-default" onclick="location.href='mypage.user' ">    
		
	</form>	
	</div>



	<jsp:include page="../include/footer.jsp"/>
	
	
	<script>
		function check() {
			
			if(document.regForm.pw.value.length < 5) {
				alert("비밀번호는 5글자 이상입니다");
				return false;
			} else if(document.regForm.pw.value != document.regForm.pw_check.value) {
				alert("비밀번호 확인란을 확인하세요");
				document.regForm.pw_check.focus();
				return false;
			} else if(document.regForm.name.value == '') {
				alert("이름은 필수 사항입니다");
				return false;
			} else {
				document.regForm.submit();
			}
			
		}
	
	</script>
	
	
	
	
	
	
	
</body>
</html>