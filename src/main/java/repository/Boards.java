package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import data.Board;

public class Boards {
	
	static final String url = "jdbc:oracle:thin:@3.34.136.30:1521:xe";
	static final String user = "C##ALPHA";
	static final String password = "1q2w3e4r";
	

	
	//게시글 작성(등록)
	public static int create(int num, String userId, String boardPass, String title, String content, String writer, Date writed) {
	
		try {
			// 1. 연결
			Connection conn = DriverManager.getConnection(url, user, password);

			// 2. 요청객체 (글작성)
			String sql = "INSERT INTO BAORDS VALUES(?, ?, ?, ?, ?, ?, "
					+ "TO_DATE(?, 'YYYY-MM-DD HH24:MI')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, userId);
			ps.setString(3, boardPass);
			ps.setString(4, title);
			ps.setString(5, content);
			ps.setString(6, writer);
			ps.setDate(7, writed);


			int r = ps.executeUpdate();
			conn.close();

			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	// 게시글 목록
	public static List<Board> boardList() {
		try {
			
			//연결
			Connection conn = DriverManager.getConnection(url, user, password);
			
			//객체 준비(게시판목록)
			String sql = " SELECT * FROM "
					+ " (SELECT * FROM BOARDS WHERE TYPE='public' AND BEGIN_DATE > SYSDATE ORDER BY BEGIN_DATE-SYSDATE) "
					+ " WHERE ROWNUM <=3";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Board> boardLi = new LinkedList<>();
			
			while(rs.next()){
				Board board = new Board();
				board.setBoardId(rs.getInt("ID"));
				board.setBoardPass(rs.getString("PASS"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setViews(rs.getInt("VIEWS"));
				board.setLikes(rs.getInt("LIKES"));
				board.setWrited(rs.getDate("DATE"));
				
				boardLi.add(board);
			}
			
			conn.close();
			return boardLi;
						
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//추천
//	public static int boardBest() {
//		
//	}
	
}