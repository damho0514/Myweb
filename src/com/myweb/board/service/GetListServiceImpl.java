package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;
import com.myweb.util.page.PageVO;

public class GetListServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//DAO에서 글 목록을 가져오는 코드.
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		int pageNum = 1; //현재 페이지번호
		int amount = 10; //몇개씩 데이터를 출력할건지
		
		//pageNum가 넘어오는 경우에만, pageNum을 변경해서 전달
		if( request.getParameter("pageNum") != null | request.getParameter("amount") != null ) {
			pageNum = Integer.parseInt(request.getParameter("pageNum") );
			amount = Integer.parseInt( request.getParameter("amount") );
		}
		
		
		//1.게시글을 구함
		ArrayList<BoardVO> list = dao.getList(pageNum, amount);
		//2.전체게시글 수 구함
		int total = dao.getTotal();
		//3.PageVO세팅
		PageVO pageVO = new PageVO(pageNum, total, amount);

		//페이지 계산결과를 request에 저장하고 화면에 전달
		request.setAttribute("pageVO", pageVO);
		
		//화면으로 가져가기 위해서 request에 저장
		request.setAttribute("list", list);
		
		
		
		
		
		
		
		
	}

}
