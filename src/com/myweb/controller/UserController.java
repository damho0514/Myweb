package com.myweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.service.DeleteServiceImpl;
import com.myweb.user.service.GetInfoServiceImpl;
import com.myweb.user.service.JoinServiceImpl;
import com.myweb.user.service.LoginServiceImpl;
import com.myweb.user.service.UpdateServiceImpl;
import com.myweb.user.service.UserService;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
		
		System.out.println(command);
		
		UserService service = null;

		if(command.equals("/user/join.user")) { //조인화면 이동
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		} else if(command.equals("/user/joinForm.user")) { //회원가입 처리 메서드
			
			service = new JoinServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) { //이미 존재하는 회원인경우
				
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('이미 존재하는 회원입니다')");
				out.println("location.href='user_join.jsp' ");
				out.println("</script>");
				
				
			} else { //회원가입 성공인 경우
				response.sendRedirect("user_login.jsp");
			}
					
		} else if(command.equals("/user/login.user")) { //로그인화면 이동
			request.getRequestDispatcher("user_login.jsp").forward(request, response);			
		} else if(command.equals("/user/loginForm.user")) { //로그인요청
			/*
			 * 1. LoginServiceImpl() 생성후에 실행
			 * 2. 서비스에서는 폼값을 받아서 DAO의 로그인 메서드를 사용해서 로그인 처리
			 * 3. 로그인에 성공하면 user_id이름으로 세션에 id를 저장하고 user_mypage로 리다이렉트
			 * 4. 로그인 실패시 out.println을 이용해서 "아이디 비밀번호를 확인하세요" 문자열을 화면에 전송
			 */
			service = new LoginServiceImpl();
			int result = service.execute(request, response);
	
			if(result == 1) { //로그인 성공
				
				String id = request.getParameter("id");
				HttpSession session = request.getSession();
				session.setAttribute("user_id", id);
				
				response.sendRedirect("user_mypage.jsp");
				
			} else { //로그인 실패
				
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out =  response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 비밀번호를 확인하세요')");
				out.println("location.href='login.user' ");
				out.println("</script>");
			}
			
		} else if(command.equals("/user/mypage.user")) {
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);			

		} else if(command.equals("/user/update.user")) { //정보변경페이지
			/*
			 * 게시판에 진입할 때 회원의 대한 모든 정보를 가져옵니다.
			 * 1. GetInfoServiceImpl 서비스를 생성하고, DAO의 getInfo()메서드로 회원 아이디에 따른 회원정보를 얻어옵니다.
			 * 2. 가져온 회원정보를 request에 저장 
			 * 3. 화면에서는 얻은 정보를 태그에 출력.
			 */
			service = new GetInfoServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("user_update.jsp").forward(request, response);
		} else if(command.equals("/user/updateForm.user")) {
			
			service = new UpdateServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) { //업데이트 성공
				response.sendRedirect("mypage.user"); //마이페이지로
			} else { //업데이트 실패
				
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보 수정에 실패했습니다')");
				out.println("location.href='user_mypage.jsp' ");
				out.println("</script>");
			}
			
		} else if(command.equals("/user/delete.user")) { //탈퇴화면 요청
			
			request.getRequestDispatcher("user_delete.jsp").forward(request, response);
		
		} else if(command.equals("/user/deleteForm.user")) { 
			
			/*
			 * 1. DeleteServiceImpl생성 DAO의 login메서드를 실행해서 ID, PW검증
			 * 2. 검증된 유저라면 DAO의 delete메서드를 실행해서 탈퇴를 진행
			 * 3. delete메서드가 1을 반환하면 세션 삭제 후에 홈 화면으로 이동
			 *    delete메서드가 0을 반환하면 "회원비밀번호를 확인하세요" 메시지를 화면에 출력하고, 
			 *    탈퇴화면으로 이동
			 */
			
			service = new DeleteServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("../main.do"); //메인컨트롤러로
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호를 확인하세요')");
				out.println("location.href='user_delete.jsp' ");
				out.println("</script>");
			}
			
		} else if(command.equals("/user/logout.user")) { //로그아웃
			
			HttpSession session = request.getSession(); 
			session.invalidate();//세션삭제
			response.sendRedirect("../main.do"); 
		}
		
		
		
		
		
		
	}

}
