package com.myweb.util.upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		location = "D:\\Aws\\course-dh\\JSP\\upload",
		maxFileSize = -1,
		maxRequestSize = -1,
		fileSizeThreshold = 1024 
)
@WebServlet("/MultiuploadServlet")
public class MultiuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MultiuploadServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> list = new ArrayList<>(); //파일 이름을 추가함
		String realFileName = null;
		
		try {
			Collection<Part> parts = request.getParts();
			
			for(Part part :parts) {
				
			System.out.println(part.getName());
			System.out.println(part.getContentType());
				
				if(part.getHeader("Content-Disposition").contains("filename=")) {
					
					if(part.getSize() > 0) {
					realFileName = part.getSubmittedFileName();
					part.write("D:\\Aws\\course-dh\\JSP\\upload\\"+ realFileName);					
					part.delete(); //임시저장파일 데이터 제거
					}
					list.add(realFileName); //리스트에 추가 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list.toString());
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement("insert into upload(id,filename) values(?,?)");
//			pstmt.setString(1, "kkk123");
//			pstmt.setString(2, fileName);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}

}
