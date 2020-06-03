package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	
	//추상메서드 (리퀘스트, 리스폰스) 매개변수로 전달받음
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
