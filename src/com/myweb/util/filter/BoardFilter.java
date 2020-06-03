package com.myweb.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1. Filter인터페이스를 상속받습니다
//2. @WebFilter 어노테이션 또는 web.xml에 필터 설정
//@WebFilter("*.board")
@WebFilter({"/board/write.board", "/board/regist.board"}) //글쓰기 화면이나 글 등록시에만 세션검사
public class BoardFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpServletRequest는 매개변수로 들어오는 ServletReqeust타입의 자식인터페이스 형이기 때문에 형변환.
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("user_id");
	
		if(id == null) {
			
			
			res.setContentType("text/html; charset=utf-8"); //응답에 대한 내용 선언
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다')");
			out.println("location.href='/MyWeb/main.do' "); //홈 화면
			out.println("</script>");
			
			return; //필터의 종료
		}
		
		//세번째 매개변수 FilterChain클래스의 메서드인 doFilter()를 실행해서 서블릿이나, 다른 필터 클래스를 실행시켜줘야 합니다.
		chain.doFilter(request, response);
		
	}

}
