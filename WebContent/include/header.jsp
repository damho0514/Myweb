<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<header>
	<!-- header -->
	<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	
                    <li>
                        <a href="<%=request.getContextPath() %>/main.do">HOME</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/member/member.jsp">Member</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/board/list.board">BOARD</a>
                    </li>
                    <li>
                        <a href="">공지사항</a>
                    </li>
                    <c:choose>
                    <c:when test="${sessionScope.user_id == null }">
	                    <li>
	                        <a href="<%=request.getContextPath()%>/user/login.user">LOGIN</a>
	                    </li>
	                    <li>
	                        <a href="<%=request.getContextPath() %>/user/join.user" style="color:red">JOIN</a>
	                    </li>
                    </c:when>
                    <c:otherwise>
	                    <li>
	                        <a href="<%=request.getContextPath()%>/user/logout.user">LOGOUT</a>
	                    </li>
	                    <li>
	                        <a href="<%=request.getContextPath() %>/user/mypage.user" style="color:red">MYPAGE</a>
	                    </li>                  
                    </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->
</header>

