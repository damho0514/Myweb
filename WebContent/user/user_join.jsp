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
		<h3>회원가입 클론코딩</h3>
		<hr>
		<form action="joinForm.user" method="post" name="reg_form">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="pw">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="pw_check">

					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="email" placeholder="abc@def.com">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address">
					</td>
				</tr>
			</table>
			
			<br>

			<input type="button" value="회원가입" class="btn btn-default" onclick="joinConfirm()"> &nbsp;&nbsp;
			<input type="reset" value="취소" class="btn btn-default" onclick="">  
			
		</form>	
	</div>
	
	<jsp:include page="../include/footer.jsp"/>
	
	
	
	<script>
		function joinConfirm() {

			//document문서를 뜻함
			//name이 reg_form 안에, name이 id 인 값
			if(document.reg_form.id.value == 0) {
				alert('아이디는 필수사항 입니다');
				reg_form.id.focus(); //reg_form에 id에 마우스를 위치시킴
				return; //강제 메서드 종료
			} else if(document.reg_form.pw.value == 0) {
				alert('비밀번호는 필수사항 입니다');
				reg_form.pw.focus();
				return;
			} else if(document.reg_form.name.value == 0) {
				alert('이름은 필수사항 입니다');
				reg_form.name.focus();
				return;
			} else if(document.reg_form.id.value.length < 4) {
				alert('아이디는 4글자 이상이어야 합니다');
				reg_form.id.focus();
				return;
			} else if(document.reg_form.pw.value != document.reg_form.pw_check.value) {
				alert('비밀번호 확인란을 확인하세요');
				reg_form.pw_check.focus();
				return;
			} else if( confirm('회원가입을 하시겠습니까?') ) {
				//confirm() 메서드는 확인, 취소 여부를 물어보는 JS메서드
				//확인 클릭시 true, 취소버튼 클릭시 false반환
				reg_form.submit(); //자바스크립트 submit() 함수
			}
		}
	
	</script>
</body>
</html>