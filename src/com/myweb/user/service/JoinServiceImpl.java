package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class JoinServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		//화면에서 넘어오는 값을 받는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.checkId(id);
		
		if( result == 1) { //이미존재하는 경우
			return 1;
		} else { //중복이 없는 경우
			
			UserVO vo = new UserVO(id, pw, name, email, address, null);
			dao.insert(vo);
			return 0;
		}
		
		
		
	}

}








