package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;

public class DeleteServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		//아이디는 세션에서 얻음
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		//비밀번호는 폼에서 얻음
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.login(id, pw);
		
		if(result == 1) { //검증된 유저
			dao.delete(id);
			session.invalidate(); //세션삭제
			return 1; //탈퇴의 성공 의미로 1을반환
		} else { //비밀번호가 틀린경우
			return 0; 
		}
		
		
		
	}

}
