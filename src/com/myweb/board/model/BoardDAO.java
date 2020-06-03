package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.user.model.UserVO;
import com.myweb.util.page.JdbcUtil;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();
	
	//2. 직접 생성할 수 없도록 생성자에 private을 붙임
	private BoardDAO() {
		//객체가 생성될때 JDBC드라이버 로딩
		try {
			
			InitialContext ct = new InitialContext(); //초기설정값이 저장됨
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle"); //연결풀을 찾아서 DS에 저장
			
		} catch (Exception e) {
			System.out.println("클래스 로딩중 에러");
		}
		
	}
	//3. 외부에서 객체생성을 요구할 때 getter메서드를 통해 반환함
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//게시글 등록 메서드
	public void regist(String writer, String title, String content) {
		
		String sql ="insert into board(bno, writer, title, content) values(board_seq.nextval, ?, ?, ?)";
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer );
			pstmt.setString(2, title );
			pstmt.setString(3, content );
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	//글 목록 조회 메서드
	public ArrayList<BoardVO> getList(int pageNum, int amount) {
		
		ArrayList<BoardVO> list = new ArrayList<>();

		//DB에서 모든 글목록을 조회해서 VO에 담고, VO를 list에 추가
		String sql = "select *\r\n" + 
					"from(\r\n" + 
					"    select rownum rn,\r\n" + 
					"           bno,\r\n" + 
					"           writer,\r\n" + 
					"           title,\r\n" + 
					"           content,\r\n" + 
					"           regdate,\r\n" + 
					"           hit\r\n" + 
					"    from(\r\n" + 
					"        select *\r\n" + 
					"        from board order by bno desc\r\n" + 
					"        )\r\n" + 
					")\r\n" + 
					"where rn > ? and rn <= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			//전달되는 페이지 번호를 받아서 쿼리문에 세팅
			//몇개의 데이터를 보여줄 건지 amount
			pstmt.setInt( 1, (pageNum - 1) * amount );
			pstmt.setInt( 2, pageNum * amount );
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(bno, writer, title, content, regdate, hit);
				
				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	//전체 게시글 수를 구하는 메서드
	public int getTotal() {
		
		int total = 0;
		
		String sql = "select count(*) as total from board";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("total");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return total;
	}
	
	
	
	//게시글 상세보기 메서드
	public BoardVO getContent(String bno) {
		
		BoardVO vo = new BoardVO();
		
		String sql = "select * from board where bno = ?";
		
		//DB에서 해당 글 목록만 조회해서 VO에 담는 코드.
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bno) );
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				
				vo.setBno( rs.getInt("bno") );
				vo.setWriter(  rs.getString("writer") );
				vo.setTitle( rs.getString("title") );
				vo.setContent( rs.getString("content") );
				vo.setRegdate( rs.getTimestamp("regdate") );
				vo.setHit( rs.getInt("hit") );
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);			
		}
		return vo;
	}
	
	//게시글 수정메서드
	public void update(String bno, String title, String content) {
		
		String sql = "update board set title = ?, content = ? where bno = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, bno);
			
			pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
	//게시글 삭제 메서드
	public void delete(String bno) {
		
		String sql = "delete from board where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
 	//조회수 관련 메서드
	public void upHit(String bno) {
		
		String sql = "update board set hit = hit + 1 where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
	}
	

	
	
	
	
}
