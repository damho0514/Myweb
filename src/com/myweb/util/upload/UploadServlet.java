package com.myweb.util.upload;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//1. 파일업로드시 어노테이션 MultipartConfig를 선언 또는 web.xml에  파일 업로드 내용을 선언

@MultipartConfig(
	location = "D:\\Aws\\course-dh\\JSP\\upload", //업로드할 경로
	maxFileSize = -1,					  //최대파일허용크기
	maxRequestSize = -1,				  //요청에 대한 최대파일허용 크기
	fileSizeThreshold = 1024			  //임시저장하는 크기
)
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반 폼값은 동일한 형식으로 받으면 됩니다.
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		
		//파일데이터는 request.getParts() 로 받습니다.
		try {
			Collection<Part> parts = request.getParts();
			
			for(Part part: parts) { //파일데이터가 담겨있는 객체를 찾는 작업
				
				System.out.println(part.getContentType());
				
				if(part.getHeader("Content-Disposition").contains("filename=")) {//파일업로드된 객체를 확인하는 코드
					
					String realFilename = part.getSubmittedFileName(); //실제 업로된 파일명
					
					if(part.getSize()>0) {//파일이 있는 경우
						part.write("D:\\Aws\\course-dh\\JSP\\upload" + realFilename);
						part.delete(); //임시로 업로된 파일을 삭제
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("업로드 중 에러발생");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
