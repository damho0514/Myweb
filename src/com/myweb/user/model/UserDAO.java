package com.myweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.myweb.util.page.JdbcUtil;

import javax.naming.InitialContext;


public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	
	//2. 직접 생성할 수 없도록 생성자에 private을 붙임
	private UserDAO() {
		//객체가 생성될때 JDBC드라이버 로딩
		try {
			
			InitialContext ct = new InitialContext(); //초기설정값이 저장됨
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle"); //연결풀을 찾아서 DS에 저장
			
		} catch (Exception e) {
			System.out.println("클래스 로딩중 에러");
		}
		
	}
	//3. 외부에서 객체생성을 요구할 때 getter메서드를 통해 반환함
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	//DAO에 회원관리에 필요한 기능을 메서드로 생성, DB관련변수를 멤버변수로 선언
	//private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	//private String uid = "JSP";
	//private String upw = "JSP";
	
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//아이디 중복검사
	public int checkId(String id) {
		
		int result = 0;
		
		String sql ="select * from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //중복의 의미
				result = 1;
			} else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//회원가입 처리
	public int insert(UserVO vo) {
		int result = 0;
		
		String sql = "insert into users(id, pw, name, email, address) values(?,?,?,?,? )";
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId() );
			pstmt.setString(2, vo.getPw() );
			pstmt.setString(3, vo.getName() );
			pstmt.setString(4, vo.getEmail() );
			pstmt.setString(5, vo.getAddress() );
			
			result = pstmt.executeUpdate(); //성공시 1, 실패시 0반환
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	
	
	//로그인 검증 메서드
	public int login(String id, String pw) {
		
		int result= 0;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //로그인 성공
				result = 1;
			} else { //로그인실패
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
			
		}
		return result;
	}
	
	//모든 회원정보를 가져오는 메서드
	public UserVO getInfo(String id) {
		
		UserVO vo = new UserVO();
		
		String sql = "select * from users where id = ?" ;
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			//pw를 제외하고, rs에 있는 회원정보를 vo담는 코드.
			if(rs.next()) {
				
				vo.setId( rs.getString("id") );
				vo.setName( rs.getString("name") );
				vo.setEmail( rs.getString("email") );
				vo.setAddress( rs.getString("address"));
				vo.setRegdate( rs.getTimestamp("regdate") );
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//회원정보 수정
	public int update(UserVO vo) {
		
		int result = 0;
		
		String sql = "update users set pw = ?, name = ?, email = ?, address = ? where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw() );
			pstmt.setString(2, vo.getName() );
			pstmt.setString(3, vo.getEmail() );
			pstmt.setString(4, vo.getAddress() );
			pstmt.setString(5, vo.getId() );
			
			result = pstmt.executeUpdate(); //성공시1 , 실패시 0
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
		
	}
	
	
	//회원탈퇴 메서드
	public int delete(String id ) {
		
		int result = 0;
		
		String sql = "delete from users where id = ?"; 
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	

	
	
	
	
	
	
	
	
	
}
